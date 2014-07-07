package piece;

import piece.Pawn;
import piece.Piece;

public class PawnTest extends PieceTest {
	
	public void testPiece() {
		
		this.points = 1.0;
		this.representation = 'p';
		
		Piece whitePiece = new Pawn(Piece.Color.WHITE);
		Piece blackPiece = new Pawn(Piece.Color.BLACK);

		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints());
		assertTrue (whitePiece.isPawn());
		assertTrue (blackPiece.isPawn());
		
	}

}
