package com.aops;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvisor implements ThrowsAdvice{
	
	public void afterThrowing(Exception ex) {
		System.out.println("Addtional consern if exception occur");
	}
}
