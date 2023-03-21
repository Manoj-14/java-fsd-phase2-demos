package com.hibernateDemo;

import org.hibernate.Session;

import com.hibernateDemo.domine.Guide;
import com.hibernateDemo.domine.Student;
import com.hibernateDemo.utils.HibernateUtil;

public class HibernateDemo {
	public static void main(String[] args) {
		demo4();
	}
	
	private static void demo4() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Guide guide = session.get(Guide.class, 1L);
		Student student = new Student("STU05", guide, "MARK");
		
		session.persist(student);
		session.getTransaction().commit();
		session.close();
	}
	
	private static void demo3() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Guide guide = session.get(Guide.class, 1L);
		System.out.println("Number of students for guide:"+guide.getStudents().size());
		
		session.getTransaction().commit();
		session.close();
	}
	
	private static void demo2() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Guide guide = new Guide("STFF02", "Robeet Clive", 50000);
		Student student1 = new Student("STU03", guide, "Karthik");

		session.persist(student1);
		
		session.getTransaction().commit();
		session.close();
	}

	private static void demo1() {
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
