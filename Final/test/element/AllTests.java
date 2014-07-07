package element;

import junit.framework.TestSuite;

public class AllTests extends TestSuite{
	
	public static TestSuite suite () {
		
		TestSuite suite = new TestSuite();
		suite.addTestSuite(CustomerTest.class);
		suite.addTestSuite(PlatformTest.class);
		suite.addTestSuite(StaffTest.class);
		suite.addTestSuite(StationMasterTest.class);
		suite.addTestSuite(TicketOfficeTest.class);
		suite.addTestSuite(TrainTest.class);
		suite.addTestSuite(WaitingLineTest.class);
		
		return suite;
	}

}