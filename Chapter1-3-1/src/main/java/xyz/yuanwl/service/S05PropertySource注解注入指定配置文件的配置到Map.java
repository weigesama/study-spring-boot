package xyz.yuanwl.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 载入自定义配置文件，注入到map。
 * @author Yuanwl
 * @date 2018-09-03 15:26:59
 * @version v1.0.0
 */
@Component
@Data
//@PropertySource({"classpath:test.properties"}) // .properties没问题
//@PropertySource({"classpath:test.yaml"}) // 换成.yaml就报错。但是把文件名改成application.yaml，注释这个注解又可以了——bug？可能这个注解不能读取.yaml
@ConfigurationProperties // 可以不写前缀
public class S05PropertySource注解注入指定配置文件的配置到Map {
	private Map<String, Map<String, String>> insurance;
}
