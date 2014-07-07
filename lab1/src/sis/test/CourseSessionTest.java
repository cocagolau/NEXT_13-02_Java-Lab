package sis.test;
import junit.framework.TestCase;
import java.util.ArrayList;
import sis_studentinfo.CourseSession;
import sis_studentinfo.DateUtil;
import sis_studentinfo.Student;
import java.util.Date;

public class CourseSessionTest extends TestCase {
	
	CourseSession session;
	private static final int CREDITS = 3;
	
	public void setUp() {
		session = new CourseSession("JAVA", "101");
	}
	
	public void testSession () {
		assertEquals ("JAVA", session.getDepartment());
		assertEquals ("101", session.getNumber());
	}
	
	public void testEnroll () {
		Student student1 = new Student("Jim");
		Student student2 = new Student("Gorden");
		Student student3 = new Student("Seo");
		
		session.enroll (student1);
		session.enroll (student2);
		session.enroll (student3);
		
		ArrayList<Student> allStudents = session.getAllStudent();
		assertEquals (3, session.getStudentsNumber());
		assertEquals (student1, allStudents.get(0));
		//assertEquals (student1, session.students.get(0));
	}
	
	public void testCourseDate () {
		CourseSession.resetCount();
		CourseSession session1 = createSession();
		assertEquals (1, CourseSession.getCount());
		
		CourseSession session2 = createSession();
		assertEquals (2, CourseSession.getCount());
	}
	
	public CourseSession createSession () {
		Date startDate = new DateUtil().createDate(2003, 0, 6);
		CourseSession session = CourseSession.create("Eng","555",startDate);
		session.setNumberOfCredits (CourseSessionTest.CREDITS);
		return session;
	}
	
	public void testStudentCredits () {
		CourseSession session = createSession();
		Student student = new Student ("seo");
		session.enroll(student);
		assertEquals(3,student.getCredit());
	}
	
}