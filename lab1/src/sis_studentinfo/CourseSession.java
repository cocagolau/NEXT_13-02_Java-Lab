package sis_studentinfo;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class CourseSession {
	
	public String department;
	public String number;
	public int numberOfStudents = 0;
	public ArrayList<Student> students = new ArrayList<Student>();
	public Date startDate;
	private static int count = 0;
	private int numberOfCredits;
	

	public static void resetCount () {
		CourseSession.count = 0;
	}
	
	public static int getCount () {
		return CourseSession.count;
	}
	
	public CourseSession (String department, String number) {
		this.department = department;
		this.number = number;
		CourseSession.count ++;
	}
	
	private CourseSession (String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	
	
	public static CourseSession create (String department, String number, Date startDate) {
		CourseSession.incrementCount();
		return new CourseSession (department, number, startDate);
	}
	
	public static void incrementCount () {
		CourseSession.count ++;
	}
	
	public void enroll (Student student1) {
		//numberOfStudents ++;
		students.add(student1);
	}
	
	public ArrayList<Student> getAllStudent() {
		return this.students;
	}
	
	public Date getEndDate() {
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		
		int numberOfDay = 16 * 7 - 3;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDay);
		
		return calendar.getTime();
	}
	
	public int getStudentsNumber() {
		return students.size();
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
}
