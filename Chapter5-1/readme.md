> by Yuanwl

# springboot整合logback基础、多环境使用

## 使用步骤

springboot默认使用logback日志工具，依赖包含在：
```xml
<!-- 核心模块，包括自动配置支持、日志和YAML等 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
</dependency>
```

所以不用配置任何东西，直接就可以使用logback。

但是，如果你想实现一些个性化需求，那就要做一些工作了：

1. 添加 [logback-spring.xml](src/main/resources/logback-spring.xml) 到resources文件夹（里面有注释）——不要修改文件名，否则还要额外配置其他东西才能正常使用；

2. 使用日志：[Application](src/main/java/xyz/yuanwl/Application.java) ；


> 参考资料

- https://www.cnblogs.com/lixuwu/p/5804793.html
- https://www.cnblogs.com/lixuwu/p/5810912.html
- https://www.cnblogs.com/lixuwu/p/5811273.html
- https://www.cnblogs.com/lixuwu/p/5816814.html
- https://blog.csdn.net/c3618392/article/details/78934904
- http://tengj.top/2017/02/28/springboot2/
- https://blog.csdn.net/qianyiyiding/article/details/76565810