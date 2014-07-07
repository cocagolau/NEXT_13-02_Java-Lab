package piece;

import board.Position;


public class Bishop extends Piece{
	private static final double POINTS = 3.0;
	private static final char REPRESENTATION = 'b';
	
	private static final Position.Move[] moves = {Position.Move.NW, Position.Move.NE, Position.Move.SW, Position.Move.SE};
	
	//constructor
	public Bishop (Piece.Color color) {
		super (color, moves);
	}
	
	@Override
	public double getPoints() {
		return Bishop.POINTS;
	}

	@Override
	public char getRepresentation() {
		if (getColor() == Piece.Color.WHITE)
			return Bishop.REPRESENTATION;
		return Character.toUpperCase(Bishop.REPRESENTATION);
	}	
	
}
