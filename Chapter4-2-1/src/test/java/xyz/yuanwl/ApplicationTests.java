package xyz.yuanwl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.yuanwl.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() throws Exception {

		// 保存字符串。用stringRedisTemplate保存，是一个数值 111；用redisTemplate保存，是一个字符串 "111"
		stringRedisTemplate.opsForValue().set("aaa", "111", 10, TimeUnit.SECONDS);
		System.err.println(stringRedisTemplate.opsForValue().get("aaa"));

		// 保存对象
		User user0 = new User("超人", 20);
		redisTemplate.opsForValue().set(user0.getUsername(), user0);

		User user1 = new User("蝙蝠侠", 30);
		redisTemplate.opsForValue().set(user1.getUsername(), user1);

		User user2 = new User("蜘蛛侠", 40);
		redisTemplate.opsForValue().set(user2.getUsername(), user2);

		List<User> list = Arrays.asList(new User[]{user0, user1, user2});
		redisTemplate.opsForValue().set("list", list);

		System.err.println(redisTemplate.opsForValue().get("超人"));
		System.err.println(redisTemplate.opsForValue().get("蝙蝠侠"));
		System.err.println(redisTemplate.opsForValue().get("蝙蝠侠"));

		List<User> listr = (List<User>) redisTemplate.opsForValue().get("list");
		System.err.println(listr);

		redisTemplate.opsForList().rightPushAll("lr", "0", "1", "2", "1");
		System.err.println(redisTemplate.opsForList().range("lr", 0, -1));
		redisTemplate.opsForList().remove("lr", 2, "1");
		System.err.println(redisTemplate.opsForList().range("lr", 0, -1));
	}

}
