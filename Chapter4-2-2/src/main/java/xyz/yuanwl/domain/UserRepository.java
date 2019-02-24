package xyz.yuanwl.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Yuanwl
 * @version 1.0.0
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable//(key = "#p0") // 这里可以不用key，因为默认就是用所有参数组合作为key值——这里就是用name值作为key。#p0代表参数1的值
    User findByName(String name);

    @CachePut(key = "#p0.name") // 每次调用方法时都更新缓存。如果不用key，因为默认用所有参数组合作为key值，所以会跟上面对不上，缓存无法正确更新
    User save(User user);

}
