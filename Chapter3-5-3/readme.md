> by Yuanwl

# MongoDB多数据源配置

## 步骤

1. 在 [application.properties](src/main/resources/application.properties) 中定义数据源属性；
2. 定义多数据源属性类 [MultipleMongoProperties](src/main/java/xyz/yuanwl/config/MultipleMongoProperties.java)，注入上面定义的属性值；
3. 定义每个数据源的配置类 [PrimaryMongoConfig](src/main/java/xyz/yuanwl/config/PrimaryMongoConfig.java)、[SecondaryMongoConfig](src/main/java/xyz/yuanwl/config/SecondaryMongoConfig.java)；
4. 定义多数据源配置类 [MultipleMongoConfig](src/main/java/xyz/yuanwl/config/MultipleMongoConfig.java)；
5. 定义实体类。实体类可以共用，如果不是共用的实体类，可以放在实体类包下面的子包里，比如primary、secondary；
6. 定义Repository，这个不可共用，每个数据源一套，分别放在primary、secondary下面；
7. 调用不同数据源的Repository，对不同数据库进行增删改查。

## 参考

https://www.cnblogs.com/wenbronk/p/6933602.html