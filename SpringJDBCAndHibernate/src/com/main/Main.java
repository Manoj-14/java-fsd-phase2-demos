package com.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.EmployeeDAO;
import com.to.Employee;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO dao = (EmployeeDAO) context.getBean("edao");

//		Employee e1 = new Employee();
//		e1.setEid(2);
//		e1.setEname("anoj");
//		e1.setAge(19);
//		e1.setPassword("anu");
//
//		int count = dao.addEmployee(e1);
//		System.out.println(count + " recoard added");

//		List<Employee> employees = dao.getAllEmployee();
//		for (Employee emp : employees) {
//			System.out.println(emp.toString());
//		}
		
		Employee e2 = new Employee();
		e2.setEid(3);
		e2.setEname("Mohan");
		e2.setAge(24);
		e2.setPassword("Han");
		
		dao.performMultipleActions(e2);

	}
}
