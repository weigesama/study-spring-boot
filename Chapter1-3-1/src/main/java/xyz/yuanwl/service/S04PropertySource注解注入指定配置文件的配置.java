package xyz.yuanwl.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 载入自定义配置文件。
 * @author Yuanwl
 * @date 2018-09-03 15:26:59
 * @version v1.0.0
 */
@Component
@Data
/* @PropertySource可以同时加载多个配置文件，也可以加载单个文件。
 * 如果多个配置文件中存在相同的属性，则最后一个配置文件里的属性起作用。
 * 加载文件的路径也可以配置变量，如下文的${xyz.yuanwl.anotherfile.configinject}，
 * 此值定义在第一个配置文件config1.properties
 * */
@PropertySource({"classpath:config1.properties",
		"classpath:config${xyz.yuanwl.anotherfile.configinject}.properties"})
@ConfigurationProperties(prefix = "xyz.yuanwl")
public class S04PropertySource注解注入指定配置文件的配置 {

//	@Value("${xyz.yuanwl.config1}") // 也可以用这个注解注入
	private String config1; // 注入第一个配置外部文件配置

//	@Value("${xyz.yuanwl.config2}")
	private String config2; // 注入第二个配置外部文件配置
}
