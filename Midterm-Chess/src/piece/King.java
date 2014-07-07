package piece;

import board.Position;

public class King extends Piece{
	private static final double POINTS = 10.0;
	private static final char REPRESENTATION = 'k';
	
	private static final Position.Move[] moves = {Position.Move.NW, Position.Move.N, Position.Move.NE, Position.Move.W, Position.Move.E, Position.Move.SW, Position.Move.S, Position.Move.SE};
	
	//constructor
	public King (Piece.Color color) {
		super (color, moves);
	}
	
	public char getReentation() {
		char type = this.representation;
		if (this.isWhite())
			return type;
		else
			return Character.toUpperCase(type);
	}
		
	@Override
	public double getPoints() {
		return King.POINTS;
	}

	@Override
	public char getRepresentation() {
		if (getColor() == Piece.Color.WHITE)
			return King.REPRESENTATION;
		return Character.toUpperCase(King.REPRESENTATION);
	}	

	@Override
	protected void irregularMoves(Position position, Position.Move move) {	
		putMovement (new Position (position.getX()+move.getX(), position.getY()+move.getY()));
	}
}