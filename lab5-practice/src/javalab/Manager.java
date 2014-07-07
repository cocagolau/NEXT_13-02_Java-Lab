package javalab;

public class Manager extends Employee {
	
	public String department;
	
	public Manager () {
		this ("",0.0,"");
	}
	public Manager (String name) {
		this (name,0.0,"");
	}
	public Manager (String name, double salary) {
		this (name,salary,"");
	}
	public Manager (String name, double salary, String department) {
		super (name, salary);
		this.department = department;
	}
	
	
	public void setDepartment (String department) {
		this.department = department;
	}
	
	public String getDepartment () {
		return this.department;
	}
	
	public String getDetails() {
		return (super.getDetails()+ ", department : " + this.department);
	}

}
