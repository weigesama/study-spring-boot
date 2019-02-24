package xyz.yuanwl.Bean注解;

import lombok.Data;

/**
 * <p>
 *
 * @author Yuanwl
 * @date 2018/9/13 11:09
 */
@Data
public class Bean1 {
	private String name;

	public Bean1(String name){
		this.name = name;
	}
}
