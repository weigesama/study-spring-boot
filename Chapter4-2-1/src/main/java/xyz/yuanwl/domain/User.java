package xyz.yuanwl.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yuanwl
 * @version 1.0.0
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

}
