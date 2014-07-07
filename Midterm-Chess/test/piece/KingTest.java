package piece;

import piece.King;
import piece.Piece;

public class KingTest extends PieceTest {
	
	public void testPiece() {
		this.points = 10.0;
		this.representation = 'k';
		
		Piece whitePiece = new King(Piece.Color.WHITE);
		Piece blackPiece = new King(Piece.Color.BLACK);

		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints());
		assertTrue (whitePiece.isKing());
		assertTrue (blackPiece.isKing());

	}

}

