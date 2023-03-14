package com.projects.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/filterDemo") // should be same the servlet which we are requesting
public class FilterDemo extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		System.out.println("Filter destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.getWriter().println("(Before requesting to servlet) Inside the filter....\n");
		response.getWriter().println("Before going to servlet");
		chain.doFilter(request, response);
		response.getWriter().println("(After response from servlet) Inside the filter....\n");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter initialized....");
	}

}
