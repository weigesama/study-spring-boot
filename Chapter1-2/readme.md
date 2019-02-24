> by Yuanwl

> **温馨提示：这一章比较难，而且内容比较多，如果看不懂，可以浏览一遍就过，等整个springboot学完后再回来看这一章。**

前面我们见识了SpringBoot为我们做的自动配置：仅引入一个 spring-boot-starter-web，就可以自动引入web和mvc相关的依赖，并且自动配置好mvc和Tomcat，确实方便快捷！但是对于新手来说，如果不大懂SpringBoot启动原理和自动配置原理，以后难免会吃亏。所以这次就跟你们一起一步步揭开SpringBoot的神秘面纱，让它不在神秘。

每个 SpringBoot 项目都会有一个启动类 [XxxApplication](src/main/java/xyz/yuanwl/Application.java) ，并使用 @SpringBootApplication 注解标记。在这个入口类中有 main 方法，如果我们想要运行该项目，main 方法中 run 我们的项目。

从启动类代码可以看出，@SpringBootApplication 注解和 SpringApplication.run 方法最为关键，所以要揭开SpringBoot的神秘面纱，我们要从这两位开始就可以了。


## 一、核心注解分析

@SpringBootApplication 注解是SpringBoot的核心注解，在默认的情况下， springboot 会扫描和这个注解修饰的启动类所在的包和子包下面所有 @Configuration、@Service等等，创建对应的bean然后加入到springboot容器中。

SpringBoot 还会根据项目中的jar包依赖，自动配置。 SpringBoot 支持的自动配置非常多。如果我们想要关闭一些自动配置的话，我们可以通过手动设置核心注解配置指出不想自动配置的jar包，比如：

```java
@SpringBootApplication(exclude = {DispatcherServlet.class,DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
```

然而，除非有必要，否则一般我们不这么做。


这个注解是怎么办到这些事的？查看源码后，你就会发现它其实是一个组合注解：

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {...}
```

我们主要了解里面三个关于 SpringBoot 的注解：

- @SpringBootConfiguration；
- @EnableAutoConfiguration；
- @ComponentScan；

### （一）@SpringBootConfiguration

这是 SpringBoot 项目的配置注解，其实它也是一个组合注解：

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringBootConfiguration {}
```

其中包含了关键的注解：@Configuration。这里的@Configuration对我们来说不陌生，它就是JavaConfig形式的Spring Ioc容器的配置类使用的那个@Configuration——该注解标注的类将会变成一个IoC容器的配置类。SpringBoot社区推荐使用基于JavaConfig的配置形式。

```
疯狂java推荐用@SpringBootConfiguration替代@Configuration，不过因为注解长度问题，往往@Configuration较为常用。
```

举几个简单例子回顾下，XML跟config配置方式的区别：

#### 1、表达形式层面

基于XML的配置形式是这样：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--bean定义-->
</beans>
```

而基于JavaConfig的配置形式是这样的：
```java
@Configuration
public class TestConfiguration {
	// bean定义
}
```

任何一个标注了@Configuration的Java类定义都是一个JavaConfig配置类。

#### 2、注册bean定义层面

基于XML的配置形式是这样：
```xml
<bean id="testService" class="...TestService"></bean>
```

而基于JavaConfig的配置形式是这样的：
```java
@Configuration
public class TestConfiguration {
	// bean定义
	@Bean
	public TestService testService(){
		return new TestService();
	}
}
```

任何一个标注了@Bean的方法，其返回值将作为一个bean定义注册到Spring的IoC容器，方法名将默认成该bean定义的id（除非在注解里手动指定新的bean名）。

#### 3、表达依赖注入关系层面

为了表达bean与bean之间的依赖关系，在XML形式中一般是这样：
```xml
<bean id="testDao" class="...TestDao"></bean>
<bean id="testService" class="...TestService">
    <property name="testDao" ref="testDao"></property>
</bean>
```

而基于JavaConfig的配置形式是这样的：
```java
@Bean
public TestDao testDao(){
    return new TestDao();
}
@Bean // 如果一个bean的定义依赖其他bean，可以把被依赖的bean直接作为参数传进去使用
public TestService testService(TestDao testDao){
    return new TestService(testDao);
}
```


常规开发中，java配置方式已经可以完全取代xml配置方式了，但有时我们并不想使用java配置，而是继续沿用之前的xml配置方式，或者出于其他原因，一定要在xml中进行配置，那该怎么办呢，很简单，使用@ImportResource注解即可：

```java
@ImportResource(value = {"classpath:xxx1.xml","classpath:xxx2.xml"})
```

### （二）@ComponentScan

组件扫描注解，自动扫描并加载符合条件的组件（比如@Component和@Repository等）或者bean定义，最终将这些bean定义加载到IoC容器中。默认扫描 @SpringBootApplication 所在类的同级包以及它的子包。所以建议把入口类放在项目包下面，可以保证项目自动扫描到所有包。不过，你也可以自己指定要扫描的包目录，例如：
```java
@ComponentScan(basePackages = "com.lqr.demo1")
```

### （三）@EnableAutoConfiguration

个人感觉@EnableAutoConfiguration这个注解最为重要，所以放在最后来解读。这个注解启用自动配置，使SpringBoot根据项目中依赖的jar包自动配置项目的相关注解配置项。比如，我们添加了spring-boot-starter-web的依赖，项目会自动引入SpringMVC和Tomcat的依赖，并且 SpringBoot 会自动配置SpringMVC和Tomcat。

这个注解是怎么办到这些事的呢？篇幅比较长，请查看另一个文档：[readme-springboot自动配置原理.md](readme-springboot自动配置原理.md)


## 二、springboot启动过程分析

篇幅很长，请看：[readme-springboot启动过程分析.md](readme-springboot启动过程分析.md)


## 三、其他常用注解

首先来补下课：[深入理解Java注解](https://blog.csdn.net/lipinganq/article/details/79089378)。

**-------------------< 下面仅总结用的比较多的注解 >-------------------**

#### 创建（声明）bean相关注解：https://blog.csdn.net/lipinganq/article/details/79155072

- @Component：泛指组件，当组件不好归类时，可以使用这个注解进行标注。一般公共的方法会用上这个注解；
- @Service：服务类；
- @Scope：用来配置 spring bean 的作用域，它标识 bean 的作用域；

#### 导入bean或xml配置文件
- @Import：导入带有 @Configuration 的java配置类（spring4.2之前），也支持导入普通的java类（4.2开始），并将其声明成一个bean，加入到spring容器。[点我了解](http://blog.51cto.com/4247649/2118354)；
- @ImportResource：导入spring配置文件；

#### 注入bean相关注解：https://blog.csdn.net/lipinganq/article/details/79167982

- @AutoWired：byType方式注入bean，可以放在构造函数、方法、方法参数、类字段以及注解上进行注入。当加上（required=false）时，就算找不到bean也不报错；
- @Qualifier注解(value = "xxx")：合格者，当存在多个类型符合的bean时，@AutoWired就会出错，这时就需要这个注解来表名哪个bean才是应该注入的；
- @Inject：等价于默认的@Autowired，只是没有required属性；
- @Resource(name="name",type="type")：与@Autowired类似，没有括号内内容的话，默认byName；

#### 替代xml实现java配置相关注解：https://blog.csdn.net/lipinganq/article/details/79303309

Spring Boot推荐使用java配置完全代替XML配置，java配置是通过 @SpringBootConfiguration/@Configuration 和 @Bean 注解实现的：

- @SpringBootConfiguration/@Configuration：声明当前类是一个配置类，相当于Spring中的一个XML文件；
- [@Bean](src/main/java/xyz/yuanwl/Bean注解)：作用在方法上，声明当前方法的返回值是一个Bean，并交给spring管理。[点我了解](https://www.cnblogs.com/feiyu127/p/7700090.html)；
- @Primary：https://www.cnblogs.com/MaxElephant/p/8182529.html https://www.jianshu.com/p/b0644c13a964

#### web相关注解（【Chapter2-1】详细介绍）
- @Controller：控制器；
- @RestController：相当于 类@Controller + 方法@ResponseBody；
- @ResponseBody：将请求方法返回值以JSON形式返回前端；
- @RequestMapping(value = "", method = RequestMethod.GET/POST/PUT/PATCH/DELETE)：指定匹配的请求路径；
- @GetMapping：相当于 @RequestMapping+Method.GET；
- @PostMapping：相当于 @RequestMapping+Method.POST；
- @PutMapping：相当于 @RequestMapping+Method.PUT；
- @DeleteMapping：相当于 @RequestMapping+Method.DELETE；
- @PathVariable：截取请求路径某一截到方法参数变量；
- @RequestParam：接受请求的参数；
- @RequestBody: 是将请求体注入方法变量中；

#### 数据库相关注解（【3、数据库】详细介绍）
- @Repository：用于标注数据访问组件，即DAO组件，默认作用域为单例；

#### 缓存相关注解（【4、缓存】详细介绍）
- @EnableCaching：用来启动缓存的标志；
- @Cacheable：支持缓存的读取；
- @CachePut：支持缓存的存储和更新；
- @CacheEvict：支持缓存的删除；

#### 异常处理相关注解（【Chapter2-5】详细介绍）
- @ControllerAdvice：把一个类定义成统一异常处理类——实际上是一个AOP切面类；
- @ExceptionHandler：结合 @ControllerAdvice 使用，放在方法上面，指定异常类，当抛出匹配的异常时，会进入到修饰的方法处理。

下面是例子：
```java
/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler({TypeMismatchException.class,NumberFormatException.class})
    public ModelAndView formatErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("error","参数类型错误");
        mav.addObject("exception", e);
        mav.addObject("url", RequestUtils.getCompleteRequestUrl(req));
        mav.addObject("timestamp", new Date());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
```

#### 配置（属性）相关注解（【Chapter1-3-1】详细介绍）
- @Value：注入单个值到属性，可以是来自于配置文件，也可以是环境变量等；
- @PropertySource：指定配置文件；
- @ConfigurationProperties：把配置文件的属性注入到类的属性，可以指定前缀、是否忽视不存在的字段；
- @EnableConfigurationProperties({Xxx.class,Yyy.class})：https://blog.csdn.net/zknxx/article/details/79183698 ；

#### 多环境切换相关注解 [源码](src/main/java/xyz/yuanwl/Profile注解和ActiveProfiles注解)
- @Profile：https://blog.csdn.net/zknxx/article/details/77906096；
- @ActiveProfiles：https://segmentfault.com/a/1190000010854678；


#### 条件注解：https://blog.csdn.net/zwmnhao1980/article/details/80746877
- @AutoConfigureBefore：??
- @AutoConfigureAfter：??

- 扩展知识：[JavaEE开发之Spring中的条件注解、组合注解与元注解](https://www.cnblogs.com/ludashi/p/6598806.html)


> 本章参考资料

- https://blog.csdn.net/doegoo/article/details/52471310
- https://blog.csdn.net/doegoo/article/details/52240841
- https://www.cnblogs.com/zheting/p/6707035.html