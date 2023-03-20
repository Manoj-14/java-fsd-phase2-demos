package com.hibernateDemo;

import com.hibernateDemo.domine.Message;
import com.hibernateDemo.utils.HibernateUtil;
import org.hibernate.Session;

public class HibernateDemo {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Message message = new Message("Second Message");
		
		session.save(message);
		session.getTransaction().commit();
		session.close();
	}
}
