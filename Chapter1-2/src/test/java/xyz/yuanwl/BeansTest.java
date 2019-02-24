package xyz.yuanwl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.yuanwl.Bean注解.Bean1;
import xyz.yuanwl.Bean注解.Bean2;


public class BeansTest extends BaseTest{

	@Autowired
	private Bean1 bean1;

	@Autowired
	private Bean2 bean2;

	@Autowired
	private Bean2 bean3;

	@Test
	public void test(){
		System.err.println(bean1);
		System.err.println(bean2);
		System.err.println(bean3);
	}

}
