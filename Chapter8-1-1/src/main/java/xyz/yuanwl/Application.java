package xyz.yuanwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 让@Async注解生效
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
