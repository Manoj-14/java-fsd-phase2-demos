package com.to;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CentralAOPAspect {
	@Pointcut("execution(* SomeBO.Valid*(..))")
	public void v() {
		System.out.println("Pointcut");
	}

	@Before("v()")
	public void beforeMethod(JoinPoint jp) {
		System.out.println("Before Method " + jp.getSignature());
	}

	@After("v()")
	public void afterMethod(JoinPoint jp) {
		System.out.println("After Method " + jp.getSignature());
	}

	@Around("v()")
	public Object myAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("addtional concern before calling actull method");
		Object obj = pjp.proceed();
		System.out.println("addtional concern after calling actull method");
		return obj;
	}
	
	@AfterThrowing(pointcut = "execution(* SomeBO.*(..))" , throwing = "error")
	public void myAdvice(JoinPoint jp,Throwable error) {
		System.out.println("Addtional concern");
		System.out.println("Method signature: "+jp.getSignature());
		System.out.println("Error occured: "+error);
		System.out.println("Method End of After throwing advice...");
	}

}
