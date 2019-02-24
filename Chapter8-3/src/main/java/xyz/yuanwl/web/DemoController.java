package xyz.yuanwl.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Yuanwl
 * @date 2018/9/21 15:19
 */
@RestController
public class DemoController {

	@GetMapping("/")
	public String index(){
		return "index";
	}
}
