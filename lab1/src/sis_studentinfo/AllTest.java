package sis_studentinfo;

import junit.framework.TestSuite;
import sis.test.CourseSessionTest;
import sis.test.StudentTest;


/**
 * 
 * @author Dec7
 * @version 1.0
 */


public class AllTest {
	
	public static TestSuite suite () {
		
		TestSuite suite = new TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		
		return suite;
		
	}

}
