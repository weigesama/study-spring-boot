package xyz.yuanwl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * MVC配置，在这里可以加入定义的拦截器
 *
 * @author Yuanwl
 * @version v1.0.0
 * @date 2018-09-11 18:55:31
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

	@Autowired
	private TestInterceptor testInterceptor;

	/**
	 * 添加拦截器
	 *
	 * @param registry
	 * @author Yuanwl
	 * @date 2018-09-11 18:57:11
	 * @version v1.0.0
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor)
				.addPathPatterns("/**");//添加拦截规则，先把所有路径都加入拦截，再一个个排除
//				.excludePathPatterns("/");//排除拦截，表示该路径不用拦截
		super.addInterceptors(registry);
	}

	/**
	 * 配置静态资源，避免静态资源请求被拦截
	 *
	 * @param registry
	 * @author Yuanwl
	 * @date 2018-09-11 18:58:41
	 * @version v1.0.0
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**") // 这是请求url的匹配模式，匹配url根路径下的所有路径（包括子路径，如果只有一个*，那就不包括子路径）
				.addResourceLocations("classpath:/static/"); // 这是文件路径的匹配模式，值上面匹配的路径在这个文件夹下面找文件
		registry.addResourceHandler("/templates/**")
				.addResourceLocations("classpath:/templates/");

		registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/"); // 上面两个是默认的，也可以加上这种自定义的

		 //		super.addResourceHandlers(registry);
	}

	//    还有以下 WebMvcConfigurerSupport 比较常用的重写接口：
	//    /** 解决跨域问题 **/
	//    public void addCorsMappings(CorsRegistry registry) ;
	//    /** 这里配置视图解析器 **/
	//    void configureViewResolvers(ViewResolverRegistry registry);
	//    /** 配置内容裁决的一些选项 **/
	//    void configureContentNegotiation(ContentNegotiationConfigurer configurer);
	//    /** 视图跳转控制器 **/
	//    void addViewControllers(ViewControllerRegistry registry);
	//    /** 默认静态资源处理器 **/
	//    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);

}
