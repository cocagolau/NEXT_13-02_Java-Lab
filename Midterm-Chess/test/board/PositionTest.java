package board;

import board.Position;
import junit.framework.TestCase;

public class PositionTest extends TestCase{
	
	public void testCreate() {
		
		Position pos = new Position("b4");
		
		assertEquals (1, pos.getX());
		assertEquals (3, pos.getY());

	}
}
