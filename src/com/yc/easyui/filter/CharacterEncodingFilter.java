package com.yc.easyui.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 编码级过滤器
 * @author Administrator
 *
 */
public class CharacterEncodingFilter implements Filter {
	private String encoding = "utf-8";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		req.setCharacterEncoding(encoding);
		resp.setCharacterEncoding(encoding);
		
		// 调用过滤器链中的下一个过滤器过滤，如果过滤器不通过，则需要调用此方法
		chain.doFilter(request, response);
	}

	/**
	 * 初始化方法，用来读取配置在这个filter中的初始化参数或全局初始化参数
	 */
	public void init(FilterConfig config) throws ServletException {
		String temp = config.getInitParameter("encoding");
		if (temp == null) {
			return;
		}
		encoding = temp;
	}

	@Override
	public void destroy() {
		
	}

}
