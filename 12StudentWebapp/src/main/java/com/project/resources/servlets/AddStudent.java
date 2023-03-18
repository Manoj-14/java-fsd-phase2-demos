package com.project.resources.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.project.utils.StudentsDataUtils;

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/studentweb")
	private DataSource dataSource;
	StudentsDataUtils studentsDataUtils;

	public void init(ServletConfig config) throws ServletException {
		try {
			studentsDataUtils = new StudentsDataUtils(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");

		studentsDataUtils.addStudent(firstname, lastname, email);

		request.setAttribute("students", studentsDataUtils.getStudents());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view_students.jsp");
		dispatcher.forward(request, response);
	}

}
