package xyz.yuanwl.Bean注解;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * <p>测试 @Bean 注解
 *
 * @author Yuanwl
 * @date 2018/9/9 18:29
 */
@SpringBootConfiguration
public class BeansConfig {

	@Bean // 创建一个bean（注解只能放在方法上面）：将下面方法的返回值，作为一个bean加入到spring上下文，名字默认就是方法名，作用就好比xml文档时代的<bean>节点
//	@Bean("beanx") // 也可以在注解上注明bean的名字
	public Bean1 bean1(){
		return new Bean1("bean1");
	}

	@Bean // Bean2的初始化要用到Bean1实体对象，可以直接作为方法参数传进去（推荐）
	public Bean2 bean2(Bean1 bean1){
		return new Bean2(bean1);
	}

	@Bean // Bean2的初始化要用到Bean1实体对象，也可以直接调用bean1的方法
	public Bean2 bean3(){
		return new Bean2(bean1());
	}

}
