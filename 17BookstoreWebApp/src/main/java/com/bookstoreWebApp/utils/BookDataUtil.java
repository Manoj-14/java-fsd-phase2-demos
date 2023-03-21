package com.bookstoreWebApp.utils;

import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;

import com.bookstoreWebApp.domine.Book;

public class BookDataUtil {

	public static void addBook(String name,String isbn,int price) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Book book = new Book(name, isbn, price);

		session.save(book);
		session.getTransaction().commit();
		session.close();
	}
	
	public static List<Book> getBooks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Book> books = session.createQuery("from Book").list();
		session.close();
		return books;
	}
}
