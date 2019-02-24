# SpringBoot2.0 快速入门教程

> 原作者：程序猿DD，非常感谢他的无私贡献！修改：Yuanwl：我把原文所有旧版本的SpringBoot，都改成了最新的2.0.4。旧版的配置在新版不能用的地方我已经改好并且注释了。然后重新排列，并丰富了一些太简单的项目，力图让各位可以尽快 了解、掌握 SpringBoot 及相关知识点；


## 一、教程使用指导

- 你需要安装java8，maven3.2+；
- 推荐用IDEA导入本项目；
- IDEA安装 Markdown Navigator 2.x ，阅读 readme.md 文档时，点击每章的 Chapter-x-x 链接，可直接打开项目文件夹或者文件（试过自带的md插件没有这样的功能），点击后面的链接可打开相关网页，方便阅读；
- 如果你学过较低版本的SpringBoot，那么可以从二开始看。并不是只看二就行了，因为有些地方新版和旧版有区别，可以浏览下面的项目去了解一下；
- 如果你零基础，那么建议你从三开始，学完之后再看二；
- 下面章节中，带 * 的可以暂时不看（星号越多代表越不用急着看）；


## 二、SpringBoot2.0 新特性学习

**简介与概览**

- [SpringBoot 2.0 正式发布，升还是不升呢？](http://blog.didispace.com/spring-boot-2-release/)
- [SpringBoot 2.0 新特性和发展方向](http://blog.didispace.com/Spring-Boot-2-0-%E6%96%B0%E7%89%B9%E6%80%A7%E5%92%8C%E5%8F%91%E5%B1%95%E6%96%B9%E5%90%91/)
- [SpringBoot 2.0 与 Java 9](http://blog.didispace.com/Spring-Boot-2.0%E4%B8%8EJava-9/)

**新特性详解**

- [SpringBoot 2.0 新特性（一）：配置绑定 2.0 全解析](http://blog.didispace.com/Spring-Boot-2-0-feature-1-relaxed-binding-2/)
- [SpringBoot 2.0 新特性（二）：新增事件ApplicationStartedEvent](http://blog.didispace.com/Spring-Boot-2-0-feature-2-ApplicationStartedEvent/)


## 三、SpringBoot 快速入门教程（基于SpringBoot2.0.4版本）

#### 1、基本知识 & 核心原理

这一章先了解一些基本知识、核心原理，以便学习后面的各种知识点。

- [Chapter1-1](Chapter1-1)：[SpringInitializr & SpringBoot 项目结构](Chapter1-1/readme.md)
- [Chapter1-2](Chapter1-2)：[核心注解分析 & 自动配置原理 & 启动过程分析 & 常用注解](Chapter1-2/readme.md)
- [Chapter1-3-1](Chapter1-3-1)：[配置（属性） & 全局配置 & 多环境配置 & 定制banner & 常用配置 & 常用依赖模块](Chapter1-3-1/readme.md)
- [Chapter1-3-2](Chapter1-3-2)：[2.0 新特性（一）：配置绑定全解析](http://blog.didispace.com/Spring-Boot-2-0-feature-1-relaxed-binding-2/)
- [Chapter1-3-3](Chapter1-3-3)：试用 .yaml （未完待续）
- [Chapter1-4](Chapter1-4)：[单元测试](Chapter1-4/readme.md)


#### 2、Web开发

- [Chapter2-1](Chapter2-1)：[构建一个较完整的RESTful API以及单元测试](http://blog.didispace.com/springbootrestfulapi/)
- [Chapter2-2](Chapter2-2)：[使用Thymeleaf模板引擎渲染web视图](http://blog.didispace.com/springbootweb/) —— 推荐这个，因为这个最接近HTML，即使脱离了SpringBoot，也不会出错。而Velocity模板在SpringBoot1.5.2后已经弃用
- [Chapter2-3](Chapter2-3)：** [使用Freemarker模板引擎渲染web视图](http://blog.didispace.com/springbootweb/)
- [Chapter2-4](Chapter2-4)：[定义listener、filter、servlet、interceptor & 资源路径修改](Chapter2-4/readme.md)
- [Chapter2-5](Chapter2-5)：[统一异常处理的两种方式](https://blog.csdn.net/hao_kkkkk/article/details/80538955)
- [Chapter2-6](Chapter2-6)：[* SpringBoot整合Swagger2构建restful API文档](Chapter2-6/readme.md)


#### 3、数据库

- [Chapter3-1-1](Chapter3-1-1)：[使用JdbcTemplate](http://blog.didispace.com/springbootdata1/)
- [Chapter3-1-2](Chapter3-1-2)：[多数据源配置（一）：JdbcTemplate](http://blog.didispace.com/springbootmultidatasource/)
- [Chapter3-2-1](Chapter3-2-1)：[使用Spring-data-jpa简化数据访问层（推荐）](http://blog.didispace.com/springbootdata2/)
- [Chapter3-2-2](Chapter3-2-2)：[多数据源配置（二）：Spring-data-jpa](http://blog.didispace.com/springbootmultidatasource/)
- [Chapter3-3-1](Chapter3-3-1)：[使用事务管理](http://blog.didispace.com/springboottransactional/)
- Chapter3-3-2：分布式事务（未完待续）
- [Chapter3-4-1](Chapter3-4-1)：[整合MyBatis](http://blog.didispace.com/springbootmybatis/)
- [Chapter3-4-2](Chapter3-4-2)：[MyBatis注解配置详解](http://blog.didispace.com/mybatisinfo/)
- [Chapter3-5-1](Chapter3-5-1)：** [使用MongoDB](https://www.jianshu.com/p/2ec104e4ab39)
- [Chapter3-5-2](Chapter3-5-2)：** [Spring Boot中增强对MongoDB的配置（连接池等）](http://blog.didispace.com/springbootmongodb-plus/)
- [Chapter3-5-3](Chapter3-5-3)：** [MongoDB多数据源配置](http://blog.didispace.com/springbootmongodb-plus/)
- [Chapter3-6-1](Chapter3-6-1)：** [使用Flyway来管理数据库版本](http://blog.didispace.com/spring-boot-flyway-db-version/)
- [Chapter3-6-2](Chapter3-6-2)：** [使用LDAP来统一管理用户信息](http://blog.didispace.com/spring-boot-ldap-user/)


#### 4、缓存
- [Chapter4-1](Chapter4-1)：* [注解配置与EhCache使用](http://blog.didispace.com/springbootcache1/)
- [Chapter4-2-1](Chapter4-2-1)：[使用Redis](http://blog.didispace.com/springbootredis/)
- [Chapter4-2-2](Chapter4-2-2)：[使用Redis做集中式缓存](http://blog.didispace.com/springbootcache2/)


#### 5、日志管理

日志框架有很多种，比较流行的有logback，log4j，log4j2，那我们应该用哪个呢？从性能和易用性两个方向来比较：

- 性能：[Log4j2的性能为什么这么好？](https://blog.csdn.net/u013970991/article/details/81705758) ，可知 log4j2 >> logback > log4j；
- 易用性：logback > log4j > log4j2；

所以，一般情况下，用logback就够了；如果对性能要求很高，就用log4j2，但是配置要麻烦点。

以下是本回内容：

- [Chapter5-1](Chapter5-1)：[springboot整合logback基础、多环境使用](Chapter5-1/readme.md)
- [Chapter5-2-1](Chapter5-2-1)：[springboot整合log4j2基础使用](Chapter5-2-1/readme.md)
- [Chapter5-2-2](Chapter5-2-2)：[springboot整合log4j2多环境使用](Chapter5-2-2/readme.md)
- [Chapter5-2-3](Chapter5-2-3)：[** springboot整合log4j2把日志记录到MongoDB](Chapter5-2-3/readme.md)
- [Chapter5-3](Chapter5-3)：[使用AOP统一处理Web请求日志](http://blog.didispace.com/springbootaoplog/)
- [Chapter5-5](Chapter5-5)：** [SpringBoot 1.5.x新特性：动态修改日志级别](http://blog.didispace.com/spring-boot-1-5-x-feature-1/)


#### 6、邮件发送

- [Chapter6](Chapter6)：[实现邮件发送：简单邮件、附件邮件、嵌入资源的邮件、模板邮件](http://blog.didispace.com/springbootmailsender/)


#### 7、消息服务

- Chapter7-1：WebSocket & SockJS & Stomp & ActiveMQ（未完待续）
- [Chapter7-2](Chapter7-2)：** [SpringBoot中使用RabbitMQ](http://blog.didispace.com/spring-boot-rabbitmq/)（因为启动RabbitMQ后一段时间就自动挂掉，所以没有继续研究...）
- Chapter7-3：JMS（未完待续）


#### 8、异步调用&定时任务&性能监控

- [Chapter8-1-1](Chapter8-1-1)：[使用@Async实现异步调用](http://blog.didispace.com/springbootasync/)
- [Chapter8-1-2](Chapter8-1-2)：[使用@Async实现异步调用：自定义线程池](http://blog.didispace.com/springbootasync-2/)
- [Chapter8-1-3](Chapter8-1-3)：[使用@Async实现异步调用：资源优雅关闭](http://blog.didispace.com/springbootasync-3/)
- [Chapter8-2-1](Chapter8-2-1)：[使用@Scheduled创建定时任务](http://blog.didispace.com/springbootscheduled/)
- [Chapter8-2-2](Chapter8-2-2)：使用@EnableScheduling创建动态定时任务（未完待续）
- [Chapter8-3](Chapter8-3)：[* 使用Actuator检查系统健康](Chapter8-3/readme.md)

#### 9、安全管理
- [Chapter9-1](Chapter9-1)：** [使用Spring Security](http://blog.didispace.com/springbootsecurity/)（未完待续）
- Chapter9-2：使用Spring Session（未完待续）
- Chapter9-3：使用Shiro（未完待续）

#### 10、其他内容（未整理待续）

- [Spring Boot应用的后台运行配置](http://blog.didispace.com/spring-boot-run-backend/)
- [ChapterX-1](ChapterX-1)：[使用Spring StateMachine框架实现状态机
](http://blog.didispace.com/spring-statemachine/)
- [ChapterX-2-1](ChapterX-2-1)：[Spring Boot中使用Dubbo进行服务治理](https://gitee.com/didispace/springboot-Learning/tree/master/ChapterX-1-1)
- [ChapterX-2-2](ChapterX-2-2)：[Spring Boot与Dubbo中管理服务依赖](https://gitee.com/didispace/springboot-Learning/tree/master/Chapter9-2-2)


## 原文链接

https://gitee.com/didispace/SpringBoot-Learning

## 开源项目推荐

- 我的《Spring Cloud基础教程》：https://github.com/dyc87112/SpringCloud-Learning
- 泥瓦匠Spring Boot学习案例：https://git.oschina.net/jeff1993/springboot-learning-example


## 其他推荐

- SpringBoot Reference Guide：http://blog.didispace.com/books/spring-boot-reference/
- Spring Boot 企业级技术：https://www.jianshu.com/nb/11055949