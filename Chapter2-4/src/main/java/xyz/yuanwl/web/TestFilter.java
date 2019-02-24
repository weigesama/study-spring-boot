package xyz.yuanwl.web;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 测试过滤器。
 * <p>通过Filter技术，对web服务器管理的所有web资源：例如Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，从而实现一些特殊的功能。
 * 例如实现URL级别的权限访问控制、过滤敏感词汇、压缩响应信息等一些高级功能。
 * 使用Filter的完整流程：Filter对用户请求进行预处理，接着将请求交给Servlet进行处理并生成响应，最后Filter再对服务器响应进行后处理。
 * @author Yuanwl
 * @date 2018/9/11 17:51
 */
@WebFilter(urlPatterns = "/*") // 标注这是一个过滤器，属性filterName声明过滤器的名称（可选）；属性urlPatterns指定要过滤的URL模式,也可使用属性value来声明(指定要过滤的URL模式是必选属性)
@Order(0) // 控制加载顺序
public class TestFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.err.println("过滤器-init...");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.err.println("过滤器-doFilter...");
		servletResponse.setCharacterEncoding("UTF-8"); // 解决乱码问题
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		System.err.println("过滤器-destroy...");
	}
}
