package xyz.yuanwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Yuanwl
 * @version 1.0.0
 */
@SpringBootApplication
@EnableCaching // 开启缓存功能，自动化配置合适的缓存管理器。本项目手动指定使用EhCache缓存
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
