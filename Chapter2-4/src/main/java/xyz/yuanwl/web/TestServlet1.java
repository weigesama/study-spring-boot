package xyz.yuanwl.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Yuanwl
 * @date 2018/9/11 18:12
 */
@WebServlet(urlPatterns = "/abc/*", description = "Servlet的说明", initParams = {@WebInitParam(name = "key", value = "key值")})
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String key = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.key = config.getInitParameter("key");
		System.err.println("初始化参数key：" + this.key);
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		out.println("TestServlet1");
		out.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		out.println("TestServlet1");
		out.flush();
	}

}
