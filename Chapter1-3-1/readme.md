> by Yuanwl

# 配置
Spring Boot 使用“习惯优于配置”的理念，很多配置都设置了默认值，可以让你基本不用配置什么就可以把项目快速运行起来。

## 一、配置来源
sb配置有多种来源，优先级从高到低排列如下：

1. 本地 Devtools 全局配置
2. 测试时 @TestPropertySource 注解配置
3. 测试时 @SpringBootTest 注解的 properties 配置
4. 命令行配置
5. SPRING_APPLICATION_JSON 配置
6. ServletConfig 初始化参数配置
7. ServletContext 初始化参数配置
8. Java 环境的 JNDI 参数配置
9. Java 系统的属性配置
10. OS 环境变量配置
11. 只能随机属性的 RandomValuePropertySource 配置
12. 工程 jar 之外的多环境配置文件（application- {profile}.properties 或 YAML）
13. 工程 jar 之内的多环境配置文件（application- {profile}.properties 或 YAML）
14. 工程 jar 之外的应用配置文件（application.properties 或 YAML）
15. 工程 jar 之内的应用配置文件（application.properties 或 YAML）
16. @Configuration 类中的 @PropertySource 注解配置
17. 默认属性配置（SpringApplication.setDefaultProperties 指定）

如果有同名配置项，优先级高的会覆盖优先级低的值。


下面我们举例说明比较常用的几种配置来源：

1. springboot 全局配置文件：application.properties 或 application.yml，这两者可以放在以下四个位置：
    - 外置，在相对于应用程序运行目录的/config子目录里；
    - 外置，在应用程序运行的目录里；
    - 内置，在config包内；
    - 内置，在Classpath根目录；

排在上面的配置，会覆盖下面的同名属性，比如src/main/resources/config下application.properties 会覆盖 src/main/resources下application.properties中相同的属性。推荐放在resources文件夹下。

application.properties 和 application.yml 可以共存，放在同一个地方，这时application.yml里面的属性就会覆盖application.properties里的属性。application的名字不能改，否则就不是全局配置文件了。详情：[application.properties](src/main/resources/application.properties)。

2. 其他配置文件，比如：[config1.properties](src/main/resources/config1.properties)。

3. 运行时通过命令行设置配置值：java -jar xxx.jar --配置名=配置值，等价于我们在application.properties中添加配置。如果你觉得程序外用命令行可以修改配置不安全，可以在代码里屏蔽这个功能。网上大部分人的教程都说用 SpringApplication.setAddCommandLineProperties(false) 来屏蔽，亲测在sb2.0.4里不行，实际上 setAddCommandLineProperties 不是静态方法，而是实例方法，例子：[Application](src/main/java/xyz/yuanwl/Application.java)；


## 二、注入配置
1. [S01Value注解不通过配置文件注入配置](src/main/java/xyz/yuanwl/service/S01Value注解不通过配置文件注入配置.java)；
2. [S02Value注解注入默认配置文件的配置](src/main/java/xyz/yuanwl/service/S02Value注解注入默认配置文件的配置.java)；
3. [S03ConfigurationProperties注解自动注入配置](src/main/java/xyz/yuanwl/service/S03ConfigurationProperties注解自动注入配置.java)；
4. [S04PropertySource注解注入指定配置文件的配置](src/main/java/xyz/yuanwl/service/S04PropertySource注解注入指定配置文件的配置.java)；

扩展阅读：http://blog.didispace.com/Spring-Boot-2-0-feature-1-relaxed-binding-2/ https://www.cnblogs.com/shamo89/p/8178109.html

## 三、多环境配置
原理和maven的差不多，更简单。使用步骤：

1. application.properties中配置通用内容，并设置spring.profiles.active=dev，以开发环境为默认配置；
2. application-dev/test/prod.properties 文件中配置各个环境不同的内容；
3. 通过命令行方式运行项目，激活不同环境的配置：java -jar xxx.jar --spring.profiles.active=dev/test/prod，连续的两个减号 -- 就是对属性值进行赋值的标识。如果你怕命令行有风险，可以使用SpringApplication.setAddCommandLineProperties(false)禁用它；


## 四、application.yaml？
网上说最好用 application.yaml 而不是 application.properties ，这个我持保留意见，各有各的优缺点，我还是先用一段时间properties吧，以后熟悉了springboot的配置，再考虑使用yaml。

- [在线转换properties为yaml](https://www.bejson.com/devtools/properties2yaml/)
- [yaml语法](http://www.ruanyifeng.com/blog/2016/07/yaml.html?f=tt)


## 五、定制banner

参考：https://www.cnblogs.com/gyjx2016/p/7479330.html


## 六、常用配置 & 常用依赖模块

- [spring-boot官方配置文档](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
- http://blog.didispace.com/springbootproperties/
- http://blog.didispace.com/Spring-Boot-2-0-feature-1-relaxed-binding-2/
- https://blog.csdn.net/kenny2020/article/details/79628943
- https://www.jianshu.com/p/55423d4b92b9
- http://www.cnblogs.com/jiyukai/p/9278993.html
