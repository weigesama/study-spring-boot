> by Yuanwl

## 使用步骤

1. pom文件引入依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

2. 去application.properties配置要打开的端点；

3. 启动项目，访问端点，比如：http://localhost:8080/actuator/health ，一般可以看到：

```json
{"status":"UP"}
```


> 参考资料

- https://blog.csdn.net/l707268743/article/details/80999322
- https://www.jianshu.com/p/1aadc4c85f51
- https://blog.csdn.net/qq_35915384/article/details/80203768
- [SpringBoot Actuator监控端点小结（旧版）](http://blog.didispace.com/spring-boot-actuator-1/)
- [在传统Spring应用中使用spring-boot-actuator模块提供监控端点（旧版）](http://blog.didispace.com/spring-boot-actuator-without-boot/)