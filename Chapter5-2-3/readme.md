> by Yuanwl

# springboot整合log4j2把日志记录到MongoDB

## 步骤

基于上一章的项目，继续修改：

1. 安装MongoDB（自己百度）；
    - MongoDB的图形化管理界面，可以安装 Robo 3T。

2. pom文件引入相关依赖；

3. 修改 application-test/prod.properties 文件，dev只保留控制台输出；

4. 修改 application.properties 中的

    ```xml
    spring.profiles.active=dev
    ```
    来使需要的环境日志记录生效，然后测试即可。


## 参考资料

- https://www.jianshu.com/p/367106c0108f
- https://blog.csdn.net/kiranet/article/details/78073000