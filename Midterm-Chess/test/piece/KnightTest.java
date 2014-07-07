package piece;

import piece.Knight;
import piece.Piece;

public class KnightTest extends PieceTest {
	
	public void testPiece() {
		this.points = 2.5;
		this.representation = 'n';
		
		Piece whitePiece = new Knight(Piece.Color.WHITE);
		Piece blackPiece = new Knight(Piece.Color.BLACK);

		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints());
		assertTrue (whitePiece.isKnight());
		assertTrue (blackPiece.isKnight());
	}

}
