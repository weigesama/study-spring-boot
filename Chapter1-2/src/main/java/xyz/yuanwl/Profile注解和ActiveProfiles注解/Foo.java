package xyz.yuanwl.Profile注解和ActiveProfiles注解;

import lombok.Data;

/**
 * <p>
 *
 * @author Yuanwl
 * @date 2018/9/22 15:47
 */
@Data
public class Foo {
	private String s;

	public Foo(String s) {
		this.s = s;
	}
}
