package piece;

import board.Position;

public class Rook extends Piece{
	private static final double POINTS = 5.0;
	private static final char REPRESENTATION = 'r';
	
	private static final Position.Move[] moves = {Position.Move.W, Position.Move.E, Position.Move.N, Position.Move.S};
	
	//constructor
	public Rook (Piece.Color color) {
		super (color, moves);
	}

	@Override
	public double getPoints() {
		return Rook.POINTS;
	}

	@Override
	public char getRepresentation() {
		if (getColor() == Piece.Color.WHITE)
			return Rook.REPRESENTATION;
		return Character.toUpperCase(Rook.REPRESENTATION);
	}	
	
}
