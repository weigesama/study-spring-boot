package xyz.yuanwl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.yuanwl.service.*;


/**
 *
 * @author Yuanwl
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

	@Autowired
	private S01Value注解不通过配置文件注入配置 v01;
	@Test
	public void test01() throws Exception {
		log.warn(v01.toString());
	}


	@Autowired
	private S02Value注解注入默认配置文件的配置 v02;
	@Test
	public void test02() throws Exception {
		log.warn(v02.toString());
	}

	@Autowired
	private S03ConfigurationProperties注解自动注入配置 v03;
	@Test
	public void test03() throws Exception {
		log.warn(v03.toString());
	}

	@Autowired
	private S04PropertySource注解注入指定配置文件的配置 v04;
	@Test
	public void test04() throws Exception {
		log.warn(v04.toString());
	}

	@Autowired
	private S05PropertySource注解注入指定配置文件的配置到Map v05;
	@Test
	public void test05(){
		log.warn(v05.toString());
	}


}
