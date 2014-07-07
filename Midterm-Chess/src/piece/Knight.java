package piece;

import util.Util;

import board.Position;

public class Knight extends Piece{
	private static final double POINTS = 2.5;
	private static final char REPRESENTATION = 'n';
	
	private static final Position.Move[] moves = {Position.Move.NW, Position.Move.SW, Position.Move.NE, Position.Move.SE};
	
	//constructor
	public Knight (Piece.Color color) {
		super (color, moves);
	}
	
	@Override
	public double getPoints() {
		return Knight.POINTS;
	}

	@Override
	public char getRepresentation() {
		if (getColor() == Piece.Color.WHITE)
			return Knight.REPRESENTATION;
		return Character.toUpperCase(Knight.REPRESENTATION);
	}	
	
	@Override
	protected void irregularMoves(Position position, Position.Move move) {
		int x = position.getX();
		int y = position.getY();
		putMovement (new Position (x + Util.doubleMove(move.getX()), y + move.getY()));
		putMovement (new Position (x + move.getX(), y + Util.doubleMove(move.getY())));
	}

}
