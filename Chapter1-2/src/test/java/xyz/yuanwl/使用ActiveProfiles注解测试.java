package xyz.yuanwl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import xyz.yuanwl.Profile注解和ActiveProfiles注解.Bar;
import xyz.yuanwl.Profile注解和ActiveProfiles注解.Foo;

/**
 * <p>如果使用 @ActiveProfiles 时，即使在 application.properties 里指定 spring.profiles.active 的值，
 * 也是 @ActiveProfiles 有效，@Profile 匹配的和没有设定 @Profile 值的Bean会被注入
 *
 * @author Yuanwl
 * @date 2018/9/22 15:51
 */
@ActiveProfiles("prod")
public class 使用ActiveProfiles注解测试 extends BaseTest {
	@Autowired
	private Foo foo;

	@Autowired
	private Bar bar;

	@Test
	public void test() {
		Assert.assertEquals("prod", foo.getS());
		Assert.assertEquals("no profile", bar.getS());
	}
}
