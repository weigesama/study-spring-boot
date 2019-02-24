package xyz.yuanwl.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Yuanwl
 * @version 1.0.0
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

}
