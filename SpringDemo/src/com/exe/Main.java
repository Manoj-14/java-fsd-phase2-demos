package com.exe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.to.SomeBO;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		SomeBO bo = (SomeBO)  context.getBean("bo");
		bo.Validate();
		try {
			bo.Validate(19);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
