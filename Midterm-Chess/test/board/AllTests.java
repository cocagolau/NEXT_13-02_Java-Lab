package board;

import junit.framework.TestSuite;

public class AllTests extends TestSuite {
	
	public static TestSuite suite () {
		
		TestSuite suite = new TestSuite();
		suite.addTestSuite(BoardTest.class);
		suite.addTestSuite(LineTest.class);
		suite.addTestSuite(PositionTest.class);
		
		return suite;
		
	}

}
