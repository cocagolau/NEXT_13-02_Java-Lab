package piece;

import junit.framework.TestSuite;

public class AllTests extends TestSuite {
	
	public static TestSuite suite () {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(KingTest.class);
		suite.addTestSuite(QueenTest.class);
		suite.addTestSuite(RookTest.class);
		suite.addTestSuite(BishopTest.class);
		suite.addTestSuite(KnightTest.class);
		suite.addTestSuite(PawnTest.class);
		suite.addTestSuite(NonePieceTest.class);
		return suite;
	}

}
