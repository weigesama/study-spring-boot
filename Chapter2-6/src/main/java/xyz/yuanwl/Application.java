package xyz.yuanwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // 启用swagger2，这个注解放Application或者MvcConfig里面都可以
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
