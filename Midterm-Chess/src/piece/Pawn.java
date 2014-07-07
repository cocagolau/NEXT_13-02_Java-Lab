package piece;

import board.Position;

public class Pawn extends Piece{
	private static final double POINTS = 1.0;
	private static final char REPRESENTATION = 'p';
	private static final Position.Move[] moves = {Position.Move.NW, Position.Move.N, Position.Move.NE};
	
	//constructor
	public Pawn (Piece.Color color) {
		super (color, moves);
	}
	
	@Override
	public double getPoints() {
		return Pawn.POINTS;
	}

	@Override
	public char getRepresentation() {
		if (getColor() == Piece.Color.WHITE)
			return Pawn.REPRESENTATION;
		return Character.toUpperCase(Pawn.REPRESENTATION);
	}	

	@Override
	protected void irregularMoves(Position position, Position.Move move) {
		int x = position.getX();
		int y = position.getY();
		int moveX = move.getX();
		int moveY = move.getY();
		
		if (getColor() == Piece.Color.WHITE)
			pawnMoves(x+moveX, y-moveY, move, -moveY);
		else
			pawnMoves(x+moveX, y+moveY, move, moveY);
	}
	
	private void pawnMoves (int x, int y, Position.Move move, int whenMoveIsUP) {
		putMovement (new Position(x, y));
		
		if (move == Position.Move.N)
			putMovement (new Position(x, y + whenMoveIsUP));	
	}
}
