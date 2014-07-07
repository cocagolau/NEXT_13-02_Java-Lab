package sis_studentinfo;

import java.util.ArrayList;
import sis_studentinfo.Student;

public class RosterReport {
	
	public static final String ROSTER_HEADER = "*************";
	public static final String ROSTER_FOOTER = "#############";
	public static final String NEWLINE = System.getProperty("line.separator");
	
	
	public ArrayList<Student> students;
	
	
	public RosterReport (CourseSession session) {
		students = session.getAllStudent();
	}
	
	public String getRosterReport() {
		StringBuilder buffer = new StringBuilder ();
		buffer.append (ROSTER_HEADER);
		
		for (Student student : students) {
			buffer.append(NEWLINE);
			buffer.append(student.getName());
		}
		buffer.append(NEWLINE+ROSTER_FOOTER + NEWLINE + students.size() + NEWLINE);
		return buffer.toString();
	}
	

}
