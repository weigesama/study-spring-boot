package xyz.yuanwl.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置
 * @author Yuanwl
 * @date 2018-09-20 19:19:42
 * @version v1.0.0
 */
@SpringBootConfiguration
public class RedisConfig {

    /**
     * 【个人推荐】自定义 RedisTemplate bean，用 GenericJackson2JsonRedisSerializer 可以把对象转json再保存到Redis。
     * <br>
     * @param connectionFactory
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.String,java.lang.Object>
     * @author Yuanwl
     * @date 2018-09-20 19:19:59
     * @version v1.0.0
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(
            RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);

        // 使用 GenericJackson2JsonRedisSerializer 替换默认的 JdkSerializationRedisSerializer 序列化
        redisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        return redisTemplate;
    }
}
