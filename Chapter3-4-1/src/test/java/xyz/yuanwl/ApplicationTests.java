package xyz.yuanwl;

import xyz.yuanwl.domain.User;
import xyz.yuanwl.domain.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback(true) // 这个注解默认为true，测试时可以改为true或删掉，以保证测试单元每次运行的数据环境独立
	public void findByName() throws Exception {
		userMapper.insert("AAA", 20);

		User u = userMapper.findByName("AAA");
		System.err.println(u);
	}

}