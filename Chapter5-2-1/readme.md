> by Yuanwl

# springboot整合log4j2基础使用

## 使用步骤

1. pom.xml 引入依赖：

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-log4j2</artifactId>
    </dependency>
    ```

    其实搞完这步已经可以正常使用log4j2了，进入3使用日志；但是这样还不能把日志写到日志文件。如果你想把日志写到日志文件，或者需要其他个性化配置，那么进入2；

2. 添加 [log4j2-spring.xml](src/main/resources/log4j2-spring.xml) 到resources文件夹——不要修改文件名，否则还要额外配置其他东西才能正常使用；

3. 使用日志，有两种方法：[ApplicationTests](src/test/java/xyz/yuanwl/ApplicationTests.java) ；


> 参考资料
- https://blog.csdn.net/V_Come_On/article/details/79408773
- https://blog.csdn.net/why_still_confused/article/details/79116565
- https://blog.csdn.net/shiyong1949/article/details/54666992