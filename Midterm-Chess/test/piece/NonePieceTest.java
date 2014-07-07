package piece;

import static util.Util.NEWSPACE;
import piece.NonePiece;
import piece.Piece;

public class NonePieceTest extends PieceTest{
	
	public void testPiece () {
		Piece nonePiece = NonePiece.getInstance();
		
		assertEquals (NEWSPACE, nonePiece.getRepresentation());
		assertEquals (Piece.Color.NONE, nonePiece.getColor());
		assertEquals (0.0, nonePiece.getPoints());
		assertTrue (nonePiece.isNonePiece());
	}

}
