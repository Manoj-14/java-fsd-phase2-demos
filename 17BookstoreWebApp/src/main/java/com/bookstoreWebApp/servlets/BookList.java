package com.bookstoreWebApp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.bookstoreWebApp.domine.Book;
import com.bookstoreWebApp.utils.BookDataUtil;
import com.bookstoreWebApp.utils.HibernateUtil;

@WebServlet("/BookList")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Book> books = BookDataUtil.getBooks();
		request.setAttribute("bookDet", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view_books.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
