package xyz.yuanwl.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yuanwl.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
