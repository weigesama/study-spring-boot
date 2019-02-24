> by Yuanwl

# springboot整合log4j2多环境使用

## 步骤

基于上一章的项目，继续修改：

1. 增加 application-dev.properties、application-prod.properties、application-test.properties；

2. 增加 log4j2-dev.xml、log4j2-prod.xml、log4j2-test.xml；

3. 在 application.properties 里面配置

    ```xml
    spring.profiles.active=dev
    ```

4. 在 application-dev/test/prod.properties 里分别指向 log4j2-dev/test/prod.xml ，搞定。

至于每个文件的区别，自己看文件。

这是我目前能想到的配置方法，如果在 .xml 里面可以用 ${} 的方式使用 .properties 的属性，那就可以弄的更简洁——然而我试了不行。
