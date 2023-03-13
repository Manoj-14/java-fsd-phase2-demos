package com.userWebApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;

@WebServlet("/listUserServlet")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/newdb", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try(Statement statement = connection.createStatement();){
			ResultSet result = statement.executeQuery("Select * from users");
			PrintWriter out = response.getWriter();
			out.println("<table border=1>");
			
			out.println("<tr>");
			out.println("<th>");
			out.println("Firstname");
			out.println("</th>");
			out.println("<th>");
			out.println("Lastname");
			out.println("</th>");
			out.println("<th>");
			out.println("Email");
			out.println("</th>");
			out.println("</tr>");
			while(result.next()) {
				String firstName = result.getString(1);
				String lastName = result.getString(2);
				String email = result.getString(3);
				out.println("<tr>");
				out.println("<td>");
				out.println(firstName);
				out.println("</td>");
				out.println("<td>");
				out.println(lastName);
				out.println("</td>");
				out.println("<td>");
				out.println(email);
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<a href=\"index.html\">Home</a>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

