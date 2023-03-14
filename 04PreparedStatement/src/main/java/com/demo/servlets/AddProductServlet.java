package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement preparedStatement;

	public void init(ServletConfig config) {

		try {
			ServletContext context = config.getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbuser = context.getInitParameter("dbuser");
			String dbpassword = context.getInitParameter("dbpassword");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
			preparedStatement = connection.prepareStatement("insert into product values(?,?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("desc");
		String price = request.getParameter("price");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (!isValidInput(id, true) || !isValidInput(name, false) || !isValidInput(description, false)
				|| !isValidInput(price, true)) {
			out.println("<h2>Please enter valid input</h2>");
			return;
		}
		try {
			preparedStatement.setInt(1, Integer.parseInt(id));
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, description);
			preparedStatement.setInt(4, Integer.parseInt(price));

			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				out.println("<h2>Product Added to database</h2>");
			} else {
				out.println("<h2>Error in inserting</h2>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean isValidInput(String inputValue, boolean isNumber) {

		if (inputValue.isBlank() || inputValue.isEmpty() || inputValue == null) {
			return false;
		} else if (isNumber) {
			try {
				Integer intValue = Integer.parseInt(inputValue);
				return true;
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
				return false;
			}
		}
		return true;
	}

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
