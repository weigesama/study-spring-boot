> by Yuanwl

## 一、使用步骤
1. 在pom.xml中加入数据库依赖；
2. application.properties中配置连接信息；
3. 直接在自己的对象中注入JdbcTemplate的Bean即可使用，不需要像Spring应用中创建那样定义一堆东西。

## 二、适用场景
完成一些快速、简单的数据库操作。比如项目上线后，数据库需要做一些紧急操作，用sql执行一些批量修改、删除操作等等，就可以用这个，不需要定义PO类，不需要mapper等等，简单易用。