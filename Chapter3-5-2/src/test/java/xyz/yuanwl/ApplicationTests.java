package xyz.yuanwl;

import com.mongodb.MongoClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.yuanwl.domain.User;
import xyz.yuanwl.domain.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

	@Autowired
	private MongoClient mongoClient;

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() {
		userRepository.deleteAll();
	} //测试前先清空数据

	@Test
	public void test() throws Exception {
		log.warn("MinConnectionsPerHost = {}, MaxConnectionsPerHost = {}",
				mongoClient.getMongoClientOptions().getMinConnectionsPerHost(),
				mongoClient.getMongoClientOptions().getConnectionsPerHost());

		// 创建三个User，并验证User总数
		userRepository.save(new User("1L", "didi", 30));
		userRepository.save(new User("2L", "mama", 40));
		userRepository.save(new User("kaka", 50)); //不手动指定id时，MongoDB将会自动产生一个类似于 ObjectId("5bab4318e9b032454ceb7027") 的id
		Assert.assertEquals(3, userRepository.findAll().size());

		// 删除一个User，再验证User总数
		User u = userRepository.findByUsername("mama");
		userRepository.delete(u);
		Assert.assertEquals(2, userRepository.findAll().size());

	}

}
