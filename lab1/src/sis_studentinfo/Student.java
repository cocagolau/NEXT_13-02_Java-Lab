package sis_studentinfo;

public class Student {
	public String name;
	private int credit;  // private�� default���� 0���� ����
	private String state = "";
	
	public static final int FULL_TIME_CREDIT = 12;
	public static final String IN_STATE = "CO";
	
	// ������, ��ü�� ������ ���� �����
	// �����ڸ� ������ ������ default constructor�� JVM�� ����
	public Student (String name) {
		this.name = name;
	}
	// ���� �����ڸ� ���� ���, ���α׷��� default constructor�� ����� ���� �����Ƿ� �Ʒ��� ���� ����
	// �����ڰ� 2�� �ִ� ���, overloading �̶���.
	// pararmeter�� �ٸ� ��� �Լ� �̸��� ���� �� ����.. �װ��� overloading
	// ���� �Լ� �̸��� ������ �� ����
	// ��ü �������� ȣ���ϴ� �Լ�, ��ü�� �̸��� ����, return value����.
	// polymorpism? ���׼�. (overloading �������� ��� )
	public Student () {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isFullTime () {
		
		if (this.credit >= Student.FULL_TIME_CREDIT) {
			return true;
		}
		return false;
	}
	
	
	public void addCredit (int credit) {
		this.credit += credit;
	}
	
	
	public int getCredit () {
		return this.credit;
	}
	// ���ü� : private, public, protected,  default <���� ��Ű��������>
	
	public boolean isInState () {
		
		return state.equals(Student.IN_STATE);
	}
	
	public void setState (String state) {
		this.state = state;
	}
	

}
