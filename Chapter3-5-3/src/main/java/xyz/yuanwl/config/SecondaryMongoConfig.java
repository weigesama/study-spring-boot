package xyz.yuanwl.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 第二数据源配置
 * @author Yuanwl
 * @date 2018-10-08 15:39:17
 * @version v1.0.0
 */
@SpringBootConfiguration
@EnableMongoRepositories(basePackages = "xyz.yuanwl.repository.secondary",
        mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE)
public class SecondaryMongoConfig {
    protected static final String MONGO_TEMPLATE = "secondaryMongoTemplate";
}