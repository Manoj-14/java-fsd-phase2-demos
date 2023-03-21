package com.hibernateDemo;

import org.hibernate.Session;

import com.hibernateDemo.domine.Guide;
import com.hibernateDemo.domine.Student;
import com.hibernateDemo.utils.HibernateUtil;

public class HibernateDemo {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Guide guide = new Guide("STFF01", "Mike Lawson", 50000);
		Student student1 = new Student("STU01", guide, "Manoj");
		Student student2 = new Student("STU02", guide, "Mohan");

		session.save(guide);
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();
		session.close();
	}
}
