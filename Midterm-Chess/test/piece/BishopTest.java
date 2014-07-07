package piece;

import piece.Bishop;
import piece.Piece;

public class BishopTest extends PieceTest {
	
	public void testPiece() {
		this.points = 3.0;
		this.representation = 'b';
		
		Piece whitePiece = new Bishop(Piece.Color.WHITE);
		Piece blackPiece = new Bishop(Piece.Color.BLACK);

		verifyCreation (whitePiece, blackPiece, whitePiece.getRepresentation(), blackPiece.getPoints());
		assertTrue (whitePiece.isBishop());
		assertTrue (blackPiece.isBishop());
	}

}
