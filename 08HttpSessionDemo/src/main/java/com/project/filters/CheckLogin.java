package com.project.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CheckLogin
 */
@WebFilter({ "/loginServlet", "/home" })
public class CheckLogin extends HttpFilter implements Filter {

	public void destroy() {
		System.out.println("Session Destroyed");
	}

	public void doFilter(HttpServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		RequestDispatcher dispatcher;
		PrintWriter out = response.getWriter();
		if(email == null) {
			dispatcher = request.getRequestDispatcher("login.html");
			out.println("User not found please login again");
			dispatcher.forward(request, response);
		}
		else {
			dispatcher = request.getRequestDispatcher("home");
			out.println("Successfully loggedIn");
			dispatcher.forward(request, response);
		}
		chain.doFilter(request,response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter initialized");
	}

}
