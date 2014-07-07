package sis_studentinfo;

public class Student {
	public String name;
	private int credit;  // private은 default값이 0으로 잡힘
	private String state = "";
	
	public static final int FULL_TIME_CREDIT = 12;
	public static final String IN_STATE = "CO";
	
	// 생성자, 객체가 생성될 때만 실행됨
	// 생성자를 만들지 않으면 default constructor를 JVM이 만듦
	public Student (String name) {
		this.name = name;
	}
	// 만약 생성자르 만든 경우, 프로그램이 default constructor를 만들어 주지 않으므로 아래와 같이 만듦
	// 생성자가 2개 있는 경우, overloading 이라함.
	// pararmeter가 다를 경우 함수 이름이 같을 수 있음.. 그것이 overloading
	// 원래 함수 이름이 동일할 수 없음
	// 객체 생성위해 호출하는 함수, 객체와 이름이 동일, return value없다.
	// polymorpism? 다항성. (overloading 생성자의 경우 )
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
	// 가시성 : private, public, protected,  default <같은 패키지에서만>
	
	public boolean isInState () {
		
		return state.equals(Student.IN_STATE);
	}
	
	public void setState (String state) {
		this.state = state;
	}
	

}
