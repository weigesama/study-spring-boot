package xyz.yuanwl;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC配置
 * @author Yuanwl
 * @date 2018-09-12 15:34:11
 * @version v1.0.0
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 自定义资源映射
     * @param registry 
     * @author Yuanwl
     * @date 2018-09-12 15:33:43
     * @version v1.0.0
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        /*
         * 在旧版本springboot或者swagger2中，最好加上下面这一段，否则可能无法打开接口文档页面。
         * 因为spring-boot有自己的一套web端拦截机制，默认把静态资源放在classpath:/static/、classpath:/templates/
         * 默认访问静态资源会被导向到这两个目录，其他的则拦截
         * 所以要将springfox-swagger-ui包中的swagger-ui.html界面暴露给spring-boot资源环境，配置正确的访问路径，才能正常访问页面
         * 不过用最新版的swagger2时发现不需要这段代码也可以正常访问，可能是swagger2自己配置了静态资源映射吧，没深究...
         */
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
    }

    /**
     * 跨域配置
     * @param registry 
     * @author Yuanwl
     * @date 2018-09-12 15:33:54
     * @version v1.0.0
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //设置允许跨域的路径
                .allowedOrigins("*") //设置允许跨域请求的域名
                .allowCredentials(true) //是否允许证书 不再默认开启
                .allowedMethods("GET", "POST", "PUT", "DELETE") //设置允许的方法
                .maxAge(3600); //跨域允许时间
    }
}