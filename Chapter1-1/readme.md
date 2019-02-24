> by Yuanwl

## 一、使用 Spring Initializr 在IDEA下快速创建springboot项目
http://blog.didispace.com/spring-initializr-in-intellij/


## 二、运行项目
右键 Application.java 运行即可。或者右键 ApplicationTests.java 运行单元测试类。


## 三、springboot 典型项目结构解析
springboot框架本身对项目结构并没有特别的要求，但是按照最佳的项目结构可以帮助我们减少可能遇到的错误问题。

### pom.xml
springboot项目必须要用maven或者gradle来处理依赖。我们用的是maven项目。自己看看这个pom文件，有注释，感受一下和普通maven项目的差异。


### main
##### java
这里放主要.java文件。假如主包名是 xyz.yuanwl ，一般我们按照以下规范划分java包：

- xyz.yuanwl.XxxApplication.java：启动类；
- xyz.yuanwl.config：需要被扫描的配置类；
- xyz.yuanwl.constant：常量类；
- xyz.yuanwl.util：工具类；
- xyz.yuanwl.web：除了Controller外的其他所有跟web有关的类，比如过滤器、拦截器等；
- xyz.yuanwl.controller：控制层；
- xyz.yuanwl.service：数据服务层，我们用激进、快速、方便的写法——只写实现类，不写接口，都在这个包里；
- xyz.yuanwl.domain：实体类和配套的数据访问接口，比如JPA项目的实体类和配套的repository，mybatis项目的实体类和mapper，放在一起方便查找；
- xyz.yuanwl.bean：包含vo和dto；

**注：以上规范以后可能还会改。**

##### resources
这里放除了java文件外的其他资源文件。一般我们按照以下规范存放资源文件：

- 根目录：springboot 主配置文件 application*.*；
- config：其他配置文件(.properties，.json，.xml等)；
- static：静态资源：
    - css：样式文件；
    - img：图片文件；
    - js：js文件；
    - （网上有人说静态html文件应该放这里面，我试了访问不到，应该还要作其他配置才行——安装前端开发规范，静态页面确实应该放在这里面）
- templates：存放.html，包括静态页面或者thymeleaf等模板文件；
- i18n：国际化资源文件；
- mapper：mybatis的.xml文件？没验证过；

**注意：springboot不推荐使用jsp，因为使用嵌入servlet容器时，有几个已知的限制。详情：https://www.cnblogs.com/xingyunblog/p/8727079.html**


### test
这里面放单元测试类。