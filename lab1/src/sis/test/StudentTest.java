package sis.test;
import junit.framework.TestCase;
import sis_studentinfo.Student;

public class StudentTest extends TestCase {
	
	public void testStudent () {
		// final은 상수화 / 변수, 함수, 클래스 사용가능
		String name1 = "Tom";
		Student student1 = new Student(name1);
		assertEquals(name1, student1.getName());
		
		String name2 = "Jim";
		Student student2 = new Student (name2);
		assertEquals(name2, student2.getName());
		
	}
	
	public void testFullTime () {
		Student student = new Student();
		assertFalse (student.isFullTime());
	}
	
	public void testStudentStatus () {
		Student student = new Student ("a");
		assertEquals (0, student.getCredit());
		
		student.addCredit(3);
		assertFalse (student.isFullTime());
		assertEquals (3, student.getCredit());
		
		student.addCredit(9);
		assertTrue (student.isFullTime());
		assertEquals (Student.FULL_TIME_CREDIT, student.getCredit());
	}
	
	public void testInState () {
		Student student = new Student ("Seo");
		assertFalse (student.isInState());
		
		student.setState (Student.IN_STATE);
		assertTrue (student.isInState());
		
		student.setState ("MD");
		assertFalse (student.isInState());
	}
	
}
