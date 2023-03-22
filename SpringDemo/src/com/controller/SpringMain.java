package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.transferobject.Employee;
import com.transferobject.Hello;

public class SpringMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee e1 = (Employee) context.getBean("e1");
		System.out.println(e1);
	}
}
