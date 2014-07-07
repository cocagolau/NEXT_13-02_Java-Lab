package suite;

import junit.framework.TestSuite;

public class AllSuite extends TestSuite {
	
	public static TestSuite suite() {
		
		TestSuite suite = new TestSuite();
		
		suite.addTest(board.AllTests.suite());
		suite.addTest(piece.AllTests.suite());
		suite.addTest(util.AllTests.suite());
		suite.addTest(chess.AllTests.suite());
		suite.addTest(factory.AllTests.suite());
		
		return suite;
	}

}
