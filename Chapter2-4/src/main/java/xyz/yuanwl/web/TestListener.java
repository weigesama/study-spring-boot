package xyz.yuanwl.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 测试监听器
 * <p>监听器用于监听web应用中某些对象、信息的创建、销毁、增加，修改，删除等动作的发生，然后作出相应的响应处理。
 * 当范围对象的状态发生变化的时候，服务器自动调用监听器对象中的方法。
 * 常用于统计在线人数和在线用户，系统加载时进行信息初始化，统计网站的访问量等等。
 * <ul>按监听的对象划分，可以分为：
 * <li>ServletContext对象监听器</li>
 * <li>HttpSession对象监听器</li>
 * <li>ServletRequest对象监听器</li>
 * </ul>
 * <ul>按监听的事件划分：
 * <li>对象自身的创建和销毁的监听器</li>
 * <li>对象中属性的创建和消除的监听器</li>
 * <li>session中的某个对象的状态变化的监听器</li>
 * </ul>
 *
 * @author Yuanwl
 * @date 2018/9/11 18:13
 */
@WebListener
public class TestListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.err.println("ServletContex初始化...");
		System.err.println(servletContextEvent.getServletContext().getServerInfo());
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.err.println("ServletContex销毁...");
	}
}
