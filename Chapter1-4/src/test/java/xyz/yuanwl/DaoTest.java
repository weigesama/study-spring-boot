package xyz.yuanwl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.yuanwl.dao.UserDao;
import xyz.yuanwl.entity.User;

// @Runwith是JUnit标准的一个注解，Spring的单元测试都用SpringRunner.class
@RunWith(SpringRunner.class)
// @SpringBootTest用于SpringBoot应用测试，默认根据报名逐级往上寻找应用启动类，所以一般不用在括号里指定启动类
@SpringBootTest
// 激活test作为profile，也就是激活 application-test.yml 配置文件的属性
@ActiveProfiles("test")
// 测试前执行下面的脚本。‘/’开头表示从classpath根目录开始搜索，没有以此开头默认在测试类所在包下。也可使用classpath:、file:、http: 开头
@Sql({"/user.sql"})
// 测试完后回滚插入的数据（创建表脚本不会回滚）。在单元测试里，因为默认 @Rollback(true) ，所以效果是测试完后数据会回滚
// 如果 @Transactional 放在非单元测试环境里，则是发生异常后才会回滚
@Transactional
public class DaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testGetOne() {
        User user = userDao.getOne(99);
        Assert.assertNotNull(user);
        Assert.assertEquals("哈哈", user.getName());
        Assert.assertSame("我们不一样~", 99, user.getId());
    }

}