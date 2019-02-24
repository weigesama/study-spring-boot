package xyz.yuanwl.service;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 载入自定义配置文件。
 * @author Yuanwl
 * @date 2018-09-03 15:26:59
 * @version v1.0.0
 */
@Component
@Data
/* @PropertySource 只能加载.properties文件
 * */
//@PropertySource({"classpath:config1.yaml",
//		"classpath:config${xyz.yuanwl.anotherfile.configinject}.yaml"})
//@ConfigurationProperties(prefix = "xyz.yuanwl")
public class S04PropertySource注解注入指定配置文件的配置 {

//	@Value("${xyz.yuanwl.config1}") // 也可以用这个注解注入
	private String config1; // 注入第一个配置外部文件配置

//	@Value("${xyz.yuanwl.config2}")
	private String config2; // 注入第二个配置外部文件配置
}
