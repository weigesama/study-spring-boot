package xyz.yuanwl.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author Yuanwl
 * @version 1.0.0
 */
@Data
public class User {

    @Id //通过@Id注解设置主键，这个主键的值是MongoDB自动生成的，生成的主键值是具有唯一性
    private String id;

    private String username;
    private Integer age;

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public User(String id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
