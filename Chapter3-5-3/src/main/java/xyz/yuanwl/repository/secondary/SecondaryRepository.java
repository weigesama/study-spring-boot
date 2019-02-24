package xyz.yuanwl.repository.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.yuanwl.domain.MongoObject;

public interface SecondaryRepository extends MongoRepository<MongoObject, String> {
}