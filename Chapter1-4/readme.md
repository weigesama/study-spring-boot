> by Yuanwl

## 一、JUnit的相关概念
- Assert：断言，当测试结果不符合给定的条件时抛出异常。如：Assert.assertSame(message, Expected, Actual) 判断Expected对象和Actual是否同一个对象(==)，不同则抛出异常提示message的信息。
- Suite：允许将多个测试类归成一组。在测试类（可空类）加注解@RunWith(Suite.class)和@SuiteClass({多个测试类})。
- Runner：Runner类用来允许测试。JUnit没有main()方法入口，其实在org.junit.runner包下有个JUnitCore.class，其中存在一个标准main方法，这就是JUnit的入口函数。


## 二、与springboot环境无关的普通单元测试

这个很简单，基本只需要一个@Test注解即可搞定。[示例](src/test/java/xyz/yuanwl/NormalTest.java)。

## 三、Dao层的单元测试

Dao层的测试需要准备一个空数据库，以及一些初始化的数据，使用 @Sql 注解来初始化：

1. 在resources文件夹（也就是classpath根目录）下准备一个初始化数据的脚本文件 [user.sql](src/test/resources/user.sql)。
2. [测试代码](src/test/java/xyz/yuanwl/DaoTest.java)。


## 四、Service层的单元测试

Service层是处理业务逻辑的地方，通常比较复杂，编写单元测试代码前需要处理好以下三个问题：

- 保证可重复测试。一个service方法可以多次测试，因此测试完毕后数据要能自动回滚。
- 模拟未完成的Service。当前测试的Service依赖的其它Service未开发完毕时，要能模拟其它Service。
- 准备测试数据。单元测试前要模拟好测试场景的数据。

如何解决呢？

- 对于第一个问题，可以使用Spring提供的 @Transactional 注解进行事务回滚。
- 对于第二个问题，使用SpringBoot集成的 Mockito 来模拟未完成的Service或者不能随便调用的Service。
- 对于第三个问题，用@Sql。

下面来看一下使用 Mockito 解决第二个问题的[示例](src/test/java/xyz/yuanwl/ServiceTest.java)。

## 五、Web层的单元测试

有两种方式：
- 通过 @WebMvcTest 来完成MVC单元测试，这种方式无法注入service层bean：[示例代码1](src/test/java/xyz/yuanwl/ControllerTest.java)；
- 通过 @SpringBootTest 配合 @WebAppConfiguration ，这种方式可以注入service层bean：[示例代码2](src/test/java/xyz/yuanwl/ControllerTest2.java)；

但是，一般在MVC的单元测试里，需要注入service调用吗？这种情况很少。


> 参考资料

- [Spring Boot使用单元测试](https://blog.csdn.net/qq27Ke/article/details/82261318)；
- [SpringBoot中mock测试controller无法注入service服务](https://blog.csdn.net/hhx0626/article/details/79560938)；