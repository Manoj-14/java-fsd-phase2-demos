package com.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement preparedStatement;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			ServletContext context = config.getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbuser = context.getInitParameter("dbuser");
			String dbpassword = context.getInitParameter("dbpassword");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
			preparedStatement = connection.prepareStatement("select * from users where email = ? and password = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			boolean result = preparedStatement.execute();
			RequestDispatcher dispatcher = null;
			ResultSet rs = null;

			if (result) {
				rs = preparedStatement.getResultSet();
			}

			if (rs.next()) {
				request.setAttribute("firstname", rs.getString(1));
				dispatcher = request.getRequestDispatcher("successServlet");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("login.html");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h4 align=center style='color:red'>Invalid credentials</h4>");
				dispatcher.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		try {
			if (connection != null) {
				connection.close();
				preparedStatement.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
