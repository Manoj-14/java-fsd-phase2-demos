package com.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RequestDispatcher dispatcher = null;
		if(username.equals("tom") && password.equals("jerry")){
			dispatcher = request.getRequestDispatcher("successServlet");
			dispatcher.forward(request, response);
		}
		else {
			dispatcher = request.getRequestDispatcher("login.html");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h4 align=center style='color:red'>Invalid credentials</h4>");
			dispatcher.include(request, response);
		}
	}

}
