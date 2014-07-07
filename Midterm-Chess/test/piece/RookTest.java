package piece;

import piece.Piece;
import piece.Rook;

public class RookTest extends PieceTest {
	
	public void testPiece() {
		
		this.points = 5.0;
		this.representation = 'r';
		
		Piece whitePiece = new Rook(Piece.Color.WHITE);
		Piece blackPiece = new Rook(Piece.Color.BLACK);

		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints());
		assertTrue (whitePiece.isRook());
		assertTrue (blackPiece.isRook());
	}

}
