package xyz.yuanwl.web;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义拦截器
 * @author Yuanwl
 * @date 2018-09-11 18:52:49
 * @version v1.0.0
 */
@Component
public class TestInterceptor implements HandlerInterceptor {  // 实现原生拦截器的接口
 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.err.println("preHandle...");
		// 进行逻辑判断，如果ok就返回true，不行就返回false，返回false就不会处理改请求
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                       ModelAndView modelAndView) throws Exception {
		System.err.println("postHandle...");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.err.println("postHandle...");
	}
}
