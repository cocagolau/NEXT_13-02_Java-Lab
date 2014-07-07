package map;

import utility.DijkstraTest;
import junit.framework.TestSuite;

public class AllTests extends TestSuite{
	
	public static TestSuite suite () {
		
		TestSuite suite = new TestSuite();
		suite.addTestSuite(DijkstraTest.class);
		suite.addTestSuite(EdgeTest.class);
		suite.addTestSuite(MapParserTest.class);
		suite.addTestSuite(RegionTest.class);
		suite.addTestSuite(TrainMapTest.class);
		
		return suite;
	}

}