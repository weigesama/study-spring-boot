package xyz.yuanwl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

	@Test
	public void test() throws Exception {
		log.info("输出info");
		log.debug("输出debug");
		log.error("输出error");
	}

}
