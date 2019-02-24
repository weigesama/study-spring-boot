package xyz.yuanwl.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yuanwl
 * @version v1.0.0
 * @date 2018-09-08 16:12:35
 */
// @RestController // 不能用这个注解，会导致所有方法返回的字符串都会作为内容响应到前端，而原本打算跳转到页面的路径字符串不起作用——这个在mvc里没有问题
@Controller // 用这个没问题
public class DemoController {

	@RequestMapping("/")
	public String index() {
		return "index"; // 返回 index 字符串表示，跳转到templates文件夹下面找文件名是 index 的页面，不管是静态还是动态模板页面都可以
	}

	@RequestMapping("/test")
	public String index(ModelMap map) {
		map.addAttribute("host", "http://blog.didispace.com"); // 给动态页面传值
		return "test";
	}

	@RequestMapping("/rest")
	@ResponseBody // 如果要让rest接口和页面方法共存，暂时我只能用这种传统的注解搞定，可能还有让@RestController生效的方法，还没研究
	public String hello() {
		return "restful";
	}

}