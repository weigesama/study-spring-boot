package xyz.yuanwl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.yuanwl.domain.MongoObject;
import xyz.yuanwl.repository.primary.PrimaryRepository;
import xyz.yuanwl.repository.secondary.SecondaryRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Autowired
	private PrimaryRepository primaryRepository;

	@Autowired
	private SecondaryRepository secondaryRepository;

	@Test
	public void TestSave() {

		System.out.println("************************************************************");
		System.out.println("测试开始");
		System.out.println("************************************************************");

		primaryRepository
				.save(new MongoObject(null, "第一个库的对象"));

		secondaryRepository
				.save(new MongoObject(null, "第二个库的对象"));

		List<MongoObject> primaries = primaryRepository.findAll();
		for (MongoObject primary : primaries) {
			System.out.println(primary.toString());
		}

		List<MongoObject> secondaries = secondaryRepository.findAll();

		for (MongoObject secondary : secondaries) {
			System.out.println(secondary.toString());
		}

		System.out.println("************************************************************");
		System.out.println("测试完成");
		System.out.println("************************************************************");
	}

}