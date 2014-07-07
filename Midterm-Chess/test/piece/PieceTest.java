package piece;


import junit.framework.TestCase;
import piece.Piece;

public abstract class PieceTest extends TestCase {
	
	protected char representation;
	protected double points;
	
	public abstract void testPiece();
	
	protected void verifyCreation (Piece whitePiece, Piece blackPiece, char representation, double points) {
	
		assertTrue(whitePiece.isWhite());
		assertEquals(this.representation, whitePiece.getRepresentation());
		assertEquals (this.points, whitePiece.getPoints());
		
		assertTrue(blackPiece.isBlack());
		assertEquals (Character.toUpperCase(this.representation), blackPiece.getRepresentation());
		assertEquals (this.points, blackPiece.getPoints());
	}
	
}
