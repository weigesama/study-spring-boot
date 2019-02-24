package xyz.yuanwl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger2 配置类
 * @author Yuanwl
 * @date 2018-09-12 15:29:42
 * @version v1.0.0
 */
@Configuration
public class Swagger2Config {

	@Bean // 创建Docket的Bean，名字是restApi，这个名字是随意的
	public Docket restApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()) // 调用下面的方法设置Api文档的基本信息（这些基本信息会展现在文档页面中）
				.select() //返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
				.apis(RequestHandlerSelectors.basePackage("xyz.yuanwl")) // 扫描这个包下面所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）
				.paths(PathSelectors.any()) //任意路径
				.build();
	}

	private ApiInfo apiInfo() { //构建api文档的详细信息
		return new ApiInfoBuilder()
				.title("SpringBoot利用Swagger2构建API文档") // 文档标题
				.contact(new Contact("Yuanwl", "https://www.baidu.com", "Yuanwl@qq.com")) //联系人
				.description("文档描述") //描述
				.termsOfServiceUrl("http://blog.csdn.net/saytime") // 服务协议
				.version("1.0") //版本号
				.build();
	}
}
