package xyz.yuanwl.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class MyStartupRunner2 implements CommandLineRunner {
@Override
public void run(String... strings) throws Exception {
    System.out.println(">>>>>>>>>>>>>>> 服务启动，执行加载数据等操作 MyStartupRunner2 <<<<<<<<<<<<<");
    }
}