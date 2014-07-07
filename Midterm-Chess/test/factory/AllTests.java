package factory;

import junit.framework.TestSuite;

public class AllTests extends TestSuite {
	
	public static TestSuite suite () {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(FactoryTest.class);
		return suite;
	}

}
