package xyz.yuanwl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.yuanwl.Profile注解和ActiveProfiles注解.Bar;
import xyz.yuanwl.Profile注解和ActiveProfiles注解.Foo;

/**
 * <p>如果没有在 application.properties 里指定 spring.profiles.active 的值，并且没用 @ActiveProfiles 时，
 * @Profile("default") 和没有设定 @Profile 值的Bean会被注入
 *
 * @author Yuanwl
 * @date 2018/9/22 15:51
 */
public class 不使用ActiveProfiles注解测试 extends BaseTest {
	@Autowired
	private Foo foo;

	@Autowired
	private Bar bar;

	@Test
	public void test() {
		Assert.assertEquals("default", foo.getS());
		Assert.assertEquals("no profile", bar.getS());
	}
}
