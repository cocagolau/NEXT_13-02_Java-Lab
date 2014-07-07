package suite;

import junit.framework.TestSuite;

public class AllSuite extends TestSuite {
	
	public static TestSuite suite() {
		
		TestSuite suite = new TestSuite();
		
		suite.addTest(element.AllTests.suite());
		suite.addTest(map.AllTests.suite());
		suite.addTest(utility.AllTests.suite());
		
		return suite;
	}

}
