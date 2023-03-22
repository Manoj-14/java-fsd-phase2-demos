package com.to;

public class Employee {
	private int empId;
	private String name;

	public Employee() {
		System.out.println("Default constructor called");
	}

	public Employee(int empId, String name) {
		System.out.println("Parameterised constructor called");
		this.empId = empId;
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		System.out.println("Setting Employee Id");
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Setting Employee name");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}

}
