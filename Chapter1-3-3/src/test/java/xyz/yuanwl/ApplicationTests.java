package xyz.yuanwl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.yuanwl.service.S01Value注解不通过配置文件注入配置;
import xyz.yuanwl.service.S02Value注解注入默认配置文件的配置;
import xyz.yuanwl.service.S03ConfigurationProperties注解自动注入配置;
import xyz.yuanwl.service.S04PropertySource注解注入指定配置文件的配置;


/**
 *
 * @author Yuanwl
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

	private static final Log log = LogFactory.getLog(ApplicationTests.class);

	@Autowired
	private S01Value注解不通过配置文件注入配置 v01;
	@Test
	public void test01() throws Exception {
		log.info(v01.toString());
	}


	@Autowired
	private S02Value注解注入默认配置文件的配置 v02;
	@Test
	public void test02() throws Exception {
		log.info(v02.toString());
	}

	@Autowired
	private S03ConfigurationProperties注解自动注入配置 v03;
	@Test
	public void test03() throws Exception {
		log.info(v03);
	}

	@Autowired
	private S04PropertySource注解注入指定配置文件的配置 v04;
	@Test
	public void test04() throws Exception {
		log.info(v04);
	}



}
