> by Yuanwl

# SpringBoot整合Swagger2构建RESTful API文档

## 一、使用步骤

1. 在pom文件加上swagger2的依赖；
2. 定义 [Swagger2Config](src/main/java/xyz/yuanwl/Swagger2Config.java)；
3. 在 [Application](src/main/java/xyz/yuanwl/Application.java) 上面加 @EnableSwagger2；
4. 通常搞完上面两步，swagger2都已经正常了，为了保险，定义 [MvcConfig](src/main/java/xyz/yuanwl/MvcConfig.java) 并且加上静态资源映射和允许跨域配置；
5. 在Controller上面加swagger2的注解，运行项目，访问 http://localhost:8080/swagger-ui.html ，没什么问题就可以看到api文档页面了；

## 二、swagger2注解

参考：https://blog.csdn.net/SIMBA1949/article/details/80926126 https://blog.csdn.net/weixin_39477597/article/details/79639239

- @Api：修饰整个类，描述Controller的作用
- @ApiOperation：描述一个类的一个方法，或者说一个接口
- @ApiParam：单个参数描述
- @ApiModel：用对象来接收参数
- @ApiModelProperty：用对象接收参数时，描述对象的一个字段
- @ApiIgnore：使用该注解忽略这个API，用于类或者方法上
- @ApiImplicitParam：一个请求参数，用于方法上
- @ApiImplicitParams：多个请求参数 ，包含多个 @ApiImplicitParam，用于方法上


## 三、swagger2汉化

https://www.jianshu.com/p/7e543f0f0bd8