package xyz.yuanwl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.yuanwl.domain.User;
import xyz.yuanwl.domain.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/user.sql")
@Transactional
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {

		// 创建10条记录
		userRepository.save(new User("AAA", 10));
		userRepository.save(new User("BBB", 20));
		userRepository.save(new User("CCC", 20));
		userRepository.save(new User("DDD", 40));
		userRepository.save(new User("EEE", 50));
		userRepository.save(new User("FFF", 60));
		userRepository.save(new User("GGG", 70));
		userRepository.save(new User("HHH", 80));
		userRepository.save(new User("III", 90));
		userRepository.save(new User("JJJ", 100));

		// 测试findAll, 查询所有记录
		System.err.println(userRepository.findAll());

		// 测试findByName, 查询姓名为FFF的User
		System.err.println(userRepository.findByName("FFF"));

		// 测试findUser, 查询姓名为FFF的User
		System.err.println(userRepository.findUser("FFF"));

		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		System.err.println(userRepository.findByNameAndAge("FFF", 60));

		// 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByName("AAA"));

		// 验证上面的删除是否成功
		System.err.println(userRepository.findByName("AAA"));

		System.err.println(userRepository.findByAge(20));

		System.err.println(userRepository.findUsersByAge(20));

	}


}
