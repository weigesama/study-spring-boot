package xyz.yuanwl.Bean注解;

import lombok.Data;

/**
 * <p>
 *
 * @author Yuanwl
 * @date 2018/9/13 11:09
 */
@Data
public class Bean2 {
	private String name;

	public Bean2(Bean1 bean1){
		this.name = "inited by " + bean1.getName();
	}
}
