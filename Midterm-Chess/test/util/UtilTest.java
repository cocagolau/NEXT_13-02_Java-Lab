package util;

import board.Position;
import util.Util;
import junit.framework.TestCase;

public class UtilTest extends TestCase {
	
	public void testUtil () {
		
		String testString = "qqqqqqqq";
		
		assertEquals (testString+'\n', Util.appendNewLine(testString));
		assertEquals (testString+'\t', Util.appendNewTap(testString));
		assertEquals (testString+' ', Util.appendNewSpace(testString));
		
		assertEquals ("a2", Util.getCode(new Position(0, 1)));
		assertEquals (4, Util.doubleMove(2));
		
	}

}
