package inheritance;


public class Employee {
	protected String name;
	public double salary;
	int i=10;
	
	/*public Employee () {
		System.out.println ("Em()");
	}*/
	
	public Employee (String name) {
		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getDetail() {
		return "name : " + name + ", salary : " + salary;
	}
	
	
}
