package inheritance;

public class Manager extends Employee {
	public String department;
	int i = 20;

	public Manager (String name) {
		super(name);
		System.out.println ("Ma ()");
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDetail() {
		return super.getDetail() + ", dept : " + department;
	}
	
	public String getDetatil2() {
		return super.getDetail();
		
	}
	
}
