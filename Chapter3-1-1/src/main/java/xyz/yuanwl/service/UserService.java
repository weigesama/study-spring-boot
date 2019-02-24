package xyz.yuanwl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuanwl
 * @version 1.0.0
 * @date 16/3/17 下午6:44.
 * @blog http://blog.didispace.com
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    /**
     * 根据name删除一个用户高
     * @param name
     */
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    /**
     * 获取用户总量
     */
    public Integer getUsersCount() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    /**
     * 查询所有用户
     * @return java.util.List<User>
     * @author Yuanwl
     * @date 2018-09-04 17:34:59
     * @version v1.0.0
     */
    public List getAllUsers() {
        return jdbcTemplate.queryForList("select * from USER");
    }

    /**
     * 删除所有用户
     */
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}
