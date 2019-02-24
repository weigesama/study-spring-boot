package xyz.yuanwl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import xyz.yuanwl.controller.UserController;
import xyz.yuanwl.service.TestService;
import xyz.yuanwl.service.UserService;

/**
 * Spring MVC Test中，Bean类不会被注册为Spring容器管理的Bean
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles("test")
public class ControllerTest2 {

	private MockMvc mockMvc; // MockMvc是Spring专门提供用于测试SpringMVC的类，这个类有很多复杂的用法，自行百度

	@Autowired
	private UserController userController;

	@MockBean
	private UserService userService; // @MockBean 用来模拟实现，因为在Spring MVC测试中并不会初始化@Service注解的类，需要自己模拟service实现。

	@Autowired // 注入service成功！！
	private TestService testService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void test() throws Exception {

		testService.print();

		int userId = 1;
		BDDMockito.given(userService.getCredit(userId)).willReturn(100);

		mockMvc.perform( // perform，完成一次MVC调用。因为MockMvc是servlet容器内部的模拟测试，所以不会发起真正的HTTP请求
				MockMvcRequestBuilders.get("/users/{id}", userId) // get，模拟一次GET请求
		)
				.andExpect( // andExpect，表示请求期望的返回结果
						MockMvcResultMatchers.content().string(String.valueOf(100))
				);

	}

}