package xyz.yuanwl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import xyz.yuanwl.controller.UserController;
import xyz.yuanwl.service.UserService;

/**
 * Spring MVC Test中，Bean类不会被注册为Spring容器管理的Bean
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class) // 表示这是一个MVC测试，括号里可传入多个待测试的Controller
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc; // MockMvc是Spring专门提供用于测试SpringMVC的类，这个类有很多复杂的用法，自行百度

	@MockBean
	private UserService userService; // @MockBean 用来模拟实现，因为在Spring MVC测试中并不会初始化@Service注解的类，需要自己模拟service实现。

//	@Autowired // 注入service失败！
//	private TestService testService;

	@Test
	public void test() throws Exception {

		int userId = 1;
		BDDMockito.given(userService.getCredit(userId)).willReturn(100);

		mockMvc.perform( // perform，完成一次MVC调用。因为MockMvc是servlet容器内部的模拟测试，所以不会发起真正的HTTP请求
				MockMvcRequestBuilders.get("/users/{id}", userId) // get，模拟一次GET请求
		)
				.andExpect( // andExpect，表示请求期望的返回结果
						MockMvcResultMatchers.content().string(String.valueOf(100))
				);

//		String[] parameters = {};
//      模拟Post请求
//        mockMvc.perform(MockMvcRequestBuilders.post("uri", parameters));

//      模拟文件上传
//        mockMvc.perform(MockMvcRequestBuilders.multipart("uri").file("fileName", "file".getBytes("UTF-8")));

//      模拟session和cookie
//        mockMvc.perform(MockMvcRequestBuilders.get("uri").sessionAttr("name", "value"));
//        mockMvc.perform(MockMvcRequestBuilders.get("uri").cookie(new Cookie("name", "value")));

//      设置HTTP Header
/*        mockMvc.perform(MockMvcRequestBuilders
                        .get("uri", parameters)
                        .contentType("application/x-www-form-urlencoded")
                        .accept("application/json")
                        .header("", ""));*/

	}

	@Test
	public void updateUser() throws Exception {
	}

}