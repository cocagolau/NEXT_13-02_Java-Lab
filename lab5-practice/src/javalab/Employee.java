package javalab;

public class Employee {
	
	public String name;
	public double salary;
	
	public Employee () {
		this ("", 0.0);
	}
	public Employee (String name) {
		this (name, 0.0);
	}
	public Employee (String name, double salary) {
		this.name = name;
		this.salary = 0.0;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setSalary (double salary) {
		this.salary = salary;
	}
	
	public String getName () {
		return this.name;
	}
	
	public double getSalary () {
		return this.salary;
	}
	
	public String getDetails() {
		return ("name : " + this.name + ", salary : " + this.salary);
	}

}
