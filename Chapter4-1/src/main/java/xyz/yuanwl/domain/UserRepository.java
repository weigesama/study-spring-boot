package xyz.yuanwl.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Yuanwl
 * @version 1.0.0
 */
@CacheConfig(cacheNames = "users") // 配置了该数据访问对象中返回的内容将存储于名为users的缓存对象中，我们也可以不使用该注解，直接通过@Cacheable自己配置缓存集的名字来定义
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable // 配置了findByName函数的返回值将被加入缓存。同时在查询时，会先从缓存中获取，若不存在才再发起对数据库的访问
//    @Cacheable(key = "#p0", condition = "#p0.length() < 10") // 使用函数第一个参数作为缓存的key值，且只有当第一个参数的长度小于3的时候才会被缓存
    User findByName(String name);

}
