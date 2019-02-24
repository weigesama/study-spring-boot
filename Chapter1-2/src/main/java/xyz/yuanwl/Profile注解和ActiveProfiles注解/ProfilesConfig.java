package xyz.yuanwl.Profile注解和ActiveProfiles注解;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 测试 @Profile 注解
 * @author Yuanwl
 * @date 2018-09-22 16:04:07
 * @version v1.0.0
 */
@Configuration
public class ProfilesConfig {

  @Bean
  @Profile("dev") // 指明这个bean属于dev环境，那么只有在dev环境里才能使用这个bean
  public Foo fooDev() {
    return new Foo("dev");
  }

  @Bean
  @Profile("test")
  public Foo fooTest() {
    return new Foo("test");
  }

  @Bean
  @Profile("prod")
  public Foo fooProd() {
    return new Foo("prod");
  }

  @Bean
  @Profile("default") // 如果没有在 application.properties 里指定 spring.profiles.active 的值，这个才是默认的profile，而不是dev
  public Foo fooDefault() {
    return new Foo("default");
  }

  @Bean
  public Bar bar() {
    return new Bar("no profile");
  }

}