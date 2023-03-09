package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddtionServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String num1 = req.getParameter("number1");
		String num2 = req.getParameter("number2");
		PrintWriter out = res.getWriter();
		
		
		if (num1.isBlank() || num1.isEmpty() || num2.isBlank() || num2.isEmpty()) {
			out.println("<p>Invalid Input</p>");
		} else {
			try {
				int number1 = Integer.parseInt(num1);
				int number2 = Integer.parseInt(num2);
				int result = number1 + number2;
				out.println("<p>Result: " + result + "</p>");
			}catch(NumberFormatException nfe) {
				out.println("<p> Please Enter the number</p>");
			}
			
		}
	}
}
