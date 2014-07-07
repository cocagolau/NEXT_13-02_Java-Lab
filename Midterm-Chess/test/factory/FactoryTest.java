package factory;

import factory.Factory;
import junit.framework.TestCase;
import piece.Piece;

public class FactoryTest extends TestCase{
	double points;
	char representation;
	Piece whitePiece, blackPiece;
	
	public void testPiece() {

		
		whitePiece = Factory.white(piece.King.class);
		blackPiece = Factory.black(piece.King.class);
		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints(), 'k', 10.0);
		assertTrue (whitePiece.isKing());
		assertTrue (blackPiece.isKing());
		
		whitePiece = Factory.white(piece.Queen.class);
		blackPiece = Factory.black(piece.Queen.class);
		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints(), 'q', 9.0);
		assertTrue (whitePiece.isQueen());
		assertTrue (blackPiece.isQueen());
		
		whitePiece = Factory.white(piece.Rook.class);
		blackPiece = Factory.black(piece.Rook.class);
		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints(), 'r', 5.0);
		assertTrue (whitePiece.isRook());
		assertTrue (blackPiece.isRook());
		
		whitePiece = Factory.white(piece.Bishop.class);
		blackPiece = Factory.black(piece.Bishop.class);
		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints(), 'b', 3.0);
		assertTrue (whitePiece.isBishop());
		assertTrue (blackPiece.isBishop());
		
		whitePiece = Factory.white(piece.Knight.class);
		blackPiece = Factory.black(piece.Knight.class);
		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints(), 'n', 2.5);
		assertTrue (whitePiece.isKnight());
		assertTrue (blackPiece.isKnight());
		
		whitePiece = Factory.white(piece.Pawn.class);
		blackPiece = Factory.black(piece.Pawn.class);
		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints(), 'p', 1.0);
		assertTrue (whitePiece.isPawn());
		assertTrue (blackPiece.isPawn());
		
	}
	
	protected void verifyCreation (Piece whitePiece, Piece blackPiece, char representation, double points, char r, double p) {
		
		assertTrue(whitePiece.isWhite());
		assertEquals(r, whitePiece.getRepresentation());
		assertEquals (p, whitePiece.getPoints());
		
		assertTrue(blackPiece.isBlack());
		assertEquals (Character.toUpperCase(r), blackPiece.getRepresentation());
		assertEquals (p, blackPiece.getPoints());
	}

}
