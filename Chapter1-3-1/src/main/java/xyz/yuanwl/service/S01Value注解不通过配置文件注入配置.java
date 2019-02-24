package xyz.yuanwl.service;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Yuanwl
 * @date 2018-09-08 18:06:14
 * @version v1.0.0
 */
@Component
@ToString
public class S01Value注解不通过配置文件注入配置 {

	@Value("xxxxx") // 注入注解里的字符串str
	private String str; // 属性不需要定义get、set方法，也可以用@Value注入

	@Value("#{systemProperties['os.name']}") // 注入操作系统配置——环境变量
	private String systemPropertiesName;

	@Value("#{systemProperties['java.home']}") // 读取环境变量，先把变量转换为全小写，再把下划线转换为.，然后就得到读取的写法了，比如这里读取的是环境变量 JAVA_HOME
	private String systemPropertiesName2;

	@Value("#{ T(java.lang.Math).random() * 100.0 }") //注入表达式结果
	private double expression;

	@Value("#{anotherBean.str}") // 注入其他Bean的配置，这个bean是被spring实例化的对象
	private String fromAnotherBean;

	@Value("classpath:config.txt") // 注入文件资源
	private Resource resourceFile;

	@Value("http://www.baidu.com") // 注入URL资源
	private Resource testUrl;

}
