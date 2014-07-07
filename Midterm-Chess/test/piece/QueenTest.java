package piece;

import piece.Piece;
import piece.Queen;

public class QueenTest extends PieceTest {
	
	public void testPiece() {
		
		this.points = 9.0;
		this.representation = 'q';
		
		Piece whitePiece = new Queen(Piece.Color.WHITE);
		Piece blackPiece = new Queen(Piece.Color.BLACK);

		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints());
		assertTrue (whitePiece.isQueen());
		assertTrue (blackPiece.isQueen());
	}

}
