package xyz.yuanwl.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 在使用SpringBoot构建项目时，我们通常有一些预先数据的加载，SpringBoot提供了一个简单的方式来实现–CommandLineRunner。
 * CommandLineRunner是一个接口，我们只需实现该接口，并加上 @Component ，就会自动被 SpringBoot 在启动生命周期里调用。
 * 如果存在多个实现，我们也可以使用@Order注解来排序。
 *
 * @author Yuanwl
 * @date 2018-09-22 16:49:37
 * @version v1.0.0
 */
@Component
@Order(value = 1)
public class MyStartupRunner1 implements CommandLineRunner {
@Override
public void run(String... strings) throws Exception {
    System.out.println(">>>>>>>>>>>>>>> 服务启动，执行加载数据等操作 MyStartupRunner1 <<<<<<<<<<<<<");
    }
}