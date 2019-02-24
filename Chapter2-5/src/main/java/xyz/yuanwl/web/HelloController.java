package xyz.yuanwl.web;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.yuanwl.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.yuanwl.service.HelloService;

/**
 * @author Yuanwl
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

    @RequestMapping("/err")
    public String hello() throws Exception {
        throw new Exception("发生错误，被Exception捕获");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误，MyException捕获");
    }

    @RequestMapping("/test")
    public void test() {
        helloService.test();
    }

}