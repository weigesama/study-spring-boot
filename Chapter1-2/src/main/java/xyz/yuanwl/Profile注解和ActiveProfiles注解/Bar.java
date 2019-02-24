package xyz.yuanwl.Profile注解和ActiveProfiles注解;

import lombok.Data;

/**
 * <p>
 *
 * @author Yuanwl
 * @date 2018/9/22 15:48
 */
@Data
public class Bar {
	private String s;

	public Bar(String s) {
		this.s = s;
	}
}
