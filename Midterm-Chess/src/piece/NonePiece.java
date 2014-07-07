package piece;

import util.Util;

public class NonePiece extends Piece {
	private static final double POINTS = 0.0;
	private static final char REPRESENTATION = Util.NEWSPACE;
	
	private static Piece nonePiece = NonePiece.createNonePiece();
	
	private NonePiece (Piece.Color color) {
		super (color, null);
	}
	
	public static NonePiece createNonePiece () {
		return new NonePiece (Piece.Color.NONE);
	}
	
	// nonePiece singleton type
	public static Piece getInstance() {
		return NonePiece.nonePiece;
	}
	
	@Override
	public double getPoints() {
		return NonePiece.POINTS;
	}

	@Override
	public char getRepresentation() {
		return NonePiece.REPRESENTATION;
	}	


}
