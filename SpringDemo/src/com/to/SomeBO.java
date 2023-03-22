package com.to;

public class SomeBO {
	public void Validate() {
		System.out.println("Validate stuff from BO");
	}
	
	public void Validate(int age) throws Exception {
		if(age<18) {
			throw new ArithmeticException("not a valid age");
		}
		else {
			System.out.println("Vote Confirmed");
		}
	}
}
