package utility;

import junit.framework.TestSuite;

public class AllTests extends TestSuite{
	
	public static TestSuite suite () {
		
		TestSuite suite = new TestSuite();
//		suite.addTestSuite(ParserTest.class);
		suite.addTestSuite(UtilTest.class);
		
		return suite;
	}

}
