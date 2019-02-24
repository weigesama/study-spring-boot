package xyz.yuanwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 * @author Yuanwl
 * @date 2018-09-08 16:12:46
 * @version v1.0.0
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		// 启动sb应用的方式1
		SpringApplication application=new SpringApplication(Application.class);
		application.run(args);

		// 启动sb应用的方式2
//		SpringApplication.run(Application.class, args);

	}

}
