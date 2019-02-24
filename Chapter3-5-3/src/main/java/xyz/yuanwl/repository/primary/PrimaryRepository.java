package xyz.yuanwl.repository.primary;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.yuanwl.domain.MongoObject;

/**
 * 主数据源的Repository，注意不能和其他数据源放在同一个包下面，否则扫描出错
 * @author Yuanwl
 * @date 2018-10-08 15:49:31
 * @version v1.0.0
 */
public interface PrimaryRepository extends MongoRepository<MongoObject, String> {
}