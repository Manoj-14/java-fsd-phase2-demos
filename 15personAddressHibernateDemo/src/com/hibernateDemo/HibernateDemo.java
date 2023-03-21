package com.hibernateDemo;


import com.hibernateDemo.domine.Address;
import com.hibernateDemo.domine.Person;
import com.hibernateDemo.utils.HibernateUtil;
import org.hibernate.Session;

public class HibernateDemo {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Address shippingAddress = new Address("VVCE", "Mysore", "570002");
		Address bilingAddress = new Address("Mahishi", "Thirthalli", "577232");
		Person person = new Person("Manoj", shippingAddress,bilingAddress);
		
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}
}
