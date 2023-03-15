package com.project.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("Session is created (listiner will be invoked)....");
		session.setAttribute("username", "tom");
		session.setAttribute("password", "jerry");
		System.out.println("Session attribute displayed (listiner to come know)....");
		session.setAttribute("username", "jim");
		System.out.println("Attribute modified (listiner to come know)....");
		session.invalidate();
		System.out.println("Session destroyed....");
	}

}
