package xyz.yuanwl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 实体类，可以给不同的数据源共用
 * @author Yuanwl
 * @date 2018-10-08 15:49:16
 * @version v1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "test")
public class MongoObject {

    @Id
    private String id;

    private String value;

    @Override
    public String toString() {
        return "MongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
                + '}';
    }
}