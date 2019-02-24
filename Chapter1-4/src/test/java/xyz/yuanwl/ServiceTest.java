package xyz.yuanwl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.yuanwl.service.UserService;
import xyz.yuanwl.service.impl.CreditSystemServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
public class ServiceTest {

    @Autowired
    private UserService userService; // UserService 依赖于 CreditSystemService，但是CreditSystemService并没有实现类

    @MockBean // 注解@MockBean 可以自动注入Spring管理的Service，这里creditSystemService由Mockito工具产生
    private CreditSystemServiceImpl creditSystemService;

    @Test
    public void test() throws Exception {

        int expectedCredit = 100;

        BDDMockito.given( // given方法配合willReturn方法，模拟出一个getUserCredit方法：传入任何值，都返回expectedCredit
                creditSystemService.getUserCredit(BDDMockito.anyInt())
            )
            .willReturn(expectedCredit);

        int userId = 10;
        int credit = userService.getCredit(userId); // userService.getCredit 调用的是模拟bean的 creditSystemService.getUserCredit 方法，返回值肯定一样

        Assert.assertEquals(expectedCredit, credit);
    }

}