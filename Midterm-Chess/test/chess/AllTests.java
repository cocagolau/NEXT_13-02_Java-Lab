package chess;

import junit.framework.TestSuite;

public class AllTests extends TestSuite {
	
	public static TestSuite suite () {
		
		TestSuite suite = new TestSuite();
		suite.addTestSuite(GameTest.class);
		
		return suite;
		
	}

}
