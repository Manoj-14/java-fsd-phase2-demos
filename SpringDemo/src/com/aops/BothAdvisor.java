package com.aops;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class BothAdvisor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("Before Mothod");
		arg0.proceed();
		System.out.println("After method");
		return null;
	}

}
