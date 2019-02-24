package xyz.yuanwl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

	// @1：使用原生log4j2
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Test
	public void testLog4j2() throws Exception {
		logger.info("输出info");
		logger.warn("输出warn");
		logger.error("输出error");
	}

	// @2：【推荐】结合Lombok、slf4j使用日志，这个更简单
	@Test
	public void testSlf4j() throws Exception {
		log.info("输出info");
		log.warn("输出warn");
		log.error("输出error");
	}
}
