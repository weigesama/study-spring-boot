package xyz.yuanwl.web;

import org.springframework.web.bind.annotation.*;

/**
 * @author Yuanwl
 * @version 1.0.0
 * @date 16/5/19 下午1:27.
 * @blog http://blog.didispace.com
 */
@RestController
public class HelloController {

    @GetMapping(value = "/")
    public String index(@RequestParam String name) {
        return "Hello " + name;
    }

}
