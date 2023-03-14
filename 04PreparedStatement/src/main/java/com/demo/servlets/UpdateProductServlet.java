package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement preparedStatement;

	@Override
	public void init(ServletConfig config) {
		try {
			ServletContext context = config.getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbuser = context.getInitParameter("dbuser");
			String dbpassword = context.getInitParameter("dbpassword");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
			preparedStatement = connection
					.prepareStatement("update products set name =?,description=?,price=? where id=?");
		} catch (SQLException | ClassNotFoundException se) {
			se.printStackTrace();
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
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, description);
			preparedStatement.setInt(3, Integer.parseInt(price));
			preparedStatement.setInt(4, Integer.parseInt(id));

			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				out.println("<h2>Product Updated</h2>");
			} else {
				out.println("<h2>Error in updating</h2>");
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
				Integer intValye = Integer.parseInt(inputValue);
				return true;
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void destroy() {
		try {
			if(connection != null) {
				connection.close();
				preparedStatement.close();
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}

}
