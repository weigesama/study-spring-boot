package xyz.yuanwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Yuanwl
 * @date 2018-09-08 18:09:36
 * @version v1.0.0
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		// 启动sb应用的方式1
		SpringApplication application=new SpringApplication(Application.class);
		// 屏蔽命令行修改配置
		application.setAddCommandLineProperties(false);
		/*
		 * 设置banner的显示模式：
		 * OFF 关闭
		 * CLOSED 后台控制台输出，默认就是这种
		 * LOG 日志输出
		 */
//		application.setBannerMode(Banner.Mode.OFF);

		ApplicationContext context = application.run(args);


		// 手动绑定复杂类型配置
		Binder binder = Binder.get(context.getEnvironment());

		// 绑定List配置
		List<Integer> list = binder.bind("xyz.yuanwl.list", Bindable.listOf(Integer.class)).get();
		System.err.println(list);

		// 绑定map配置
		Map<String, Integer> map = binder.bind("xyz.yuanwl.map", Bindable.mapOf(String.class, Integer.class)).get();
		System.err.println(map);

	}

}
