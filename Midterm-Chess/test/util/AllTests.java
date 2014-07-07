package util;

import junit.framework.TestSuite;

public class AllTests extends TestSuite {
	
	public static TestSuite suite () {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(UtilTest.class);
		suite.addTestSuite(CharacterTest.class);
		return suite;
	}

}
