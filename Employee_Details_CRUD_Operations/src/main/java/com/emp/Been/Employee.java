package com.emp.Been;

public class Employee {
	
	protected int num;
	protected String empid;
    protected String name;
	protected String designation;
	protected int salary;
	
	
	public Employee() {
	}


	public Employee(String empid, String name, String designation, int salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}


	public Employee(int num, String empid, String name, String designation, int salary) {
		super();
		this.num = num;
		this.empid = empid;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}


	public int getNum() {
		return num;
	}


	public void setId(int num) {
		this.num = num;
	}


	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	

}
