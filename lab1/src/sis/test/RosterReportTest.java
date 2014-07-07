package sis.test;
import java.util.Date;

import sis_studentinfo.CourseSession;
import sis_studentinfo.RosterReport;
import sis_studentinfo.DateUtil;
import sis_studentinfo.Student;
import junit.framework.TestCase;

public class RosterReportTest extends TestCase {

	CourseSession session;
		
	public void testRosterReport() {
		
		Date date = new DateUtil().createDate (2013, 6, 12);
		session = CourseSession.create ("C++", "111", date);
		session.enroll(new Student("Bruce Lee"));
		session.enroll(new Student("Elice Lee"));
		
		
		RosterReport report = new RosterReport (session);
		
		String reportContents = report.getRosterReport();
		assertEquals (RosterReport.ROSTER_HEADER
				+ RosterReport.NEWLINE
				+ "Bruce Lee" 
				+ RosterReport.NEWLINE
				+ "Elice Lee"
				+ RosterReport.NEWLINE
				+ RosterReport.ROSTER_FOOTER
				+ RosterReport.NEWLINE
				+ 2
				+ RosterReport.NEWLINE, reportContents);
		
		System.out.println (reportContents);
		
	}

}
