package xyz.yuanwl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.yuanwl.entity.User;
import xyz.yuanwl.service.UserService;

/**
 * @author Yuanwl
 * @since 2018/06/23
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/")
	public String insertUser(Integer id, String name){
		User user = new User();
		user.setId(id);
		user.setName(name);
		userService.saveUser(user);
		return "{\"success\":true}";
	}

	@GetMapping("/{id}")
	public String getUser(@PathVariable Integer id){
		return String.valueOf(userService.getCredit(id));
	}

	@PutMapping("/user/{id}/{name}")
	public String updateUser(@PathVariable Integer id,@PathVariable String name){
		User user = new User();
		user.setId(id);
		user.setName(name);
		userService.updateUser(user);
		return "{\"success\":true}";
	}

}
