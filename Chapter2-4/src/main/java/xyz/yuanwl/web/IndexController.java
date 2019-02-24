package xyz.yuanwl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Yuanwl
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@Controller
public class IndexController {

    @Autowired
    private TestInterceptor testInterceptor;

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        System.err.println(testInterceptor);
        return "Hello World";
    }

}