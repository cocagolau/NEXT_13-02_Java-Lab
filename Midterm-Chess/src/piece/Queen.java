package piece;

import board.Position;

public class Queen extends Piece{
	private static final double POINTS = 9.0;
	private static final char REPRESENTATION = 'q';
	
	private static final Position.Move[] moves = {Position.Move.NW, Position.Move.N, Position.Move.NE, Position.Move.W, Position.Move.E, Position.Move.SW, Position.Move.S, Position.Move.SE};
	
	//constructor
	public Queen (Piece.Color color) {
		super (color, moves);
	}
	
	@Override
	public double getPoints() {
		return Queen.POINTS;
	}

	@Override
	public char getRepresentation() {
		if (getColor() == Piece.Color.WHITE)
			return Queen.REPRESENTATION;
		return Character.toUpperCase(Queen.REPRESENTATION);
	}	

}
