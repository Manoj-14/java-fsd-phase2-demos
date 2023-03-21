package com.bookstoreWebApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstoreWebApp.domine.Book;
import com.bookstoreWebApp.utils.BookDataUtil;
import com.bookstoreWebApp.utils.HibernateUtil;
import org.hibernate.Session;


@WebServlet("/addBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String isbn = request.getParameter("isbn");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookDataUtil.addBook(name, isbn, price);
		
		List<Book> books = BookDataUtil.getBooks();
		request.setAttribute("bookDet", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view_books.jsp");
		dispatcher.forward(request, response);
	}

}
