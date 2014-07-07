package piece;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.Position;

/**
 * 
 * @author Dec7
 * @see ArrayList
 * @see Comparable
 * @version 1.0
 * @since 1.0
 *
 */

public abstract class Piece implements Comparable<Piece>{
	
	private Position.Move[] moves;
	protected List<Position> possibleMoves;
	protected Position pos;
	protected double point;
	protected char representation;
	protected Piece.Color color;
	

	public enum Color { NONE, WHITE, BLACK; }
		
	// private constructor
	protected Piece(Piece.Color color, Position.Move[] moves) {
		this.color = color;
		this.moves = moves;
	}
	
	/** 
	 * Comparable �������̽��� ���ǵǾ��ִ� compareTo�޼ҵ�
	 * @param that	PieceŸ��
	 * @return -1 : �ڱ� �ν��Ͻ��� getPoints()������ ���ڷ� ���� Piece�ν��Ͻ��� getPoints() ���� Ŭ���
	 *          0 : ���� ���
	 *          1 : �������
	 */
	@Override
	public int compareTo(Piece that) {

		double x = this.getPoints();
		double y = that.getPoints();
	
		if      (x>y)  return -1;
		else if (x==y) return 0;
		else		   return 1;
	}
	
	/**
	 * this��ü�� ���¸� boolean������ ��ȯ
	 * @return true : this�� color������ ���� WHITE�϶�
	 */
	public boolean isWhite() {
		return this.color.equals(Piece.Color.WHITE);
	}
	/**
	 * @return true : this�� color������ ���� BLACKE�϶�
	 */
	public boolean isBlack() {
		return this.color.equals(Piece.Color.BLACK);
	}
	/**
	 * @return true : this�� King.class�� ���
	 */
	public boolean isKing() {
		return this.getClass().equals(piece.King.class);
	}
	/**
	 * @return true : this�� Queen.class�� ���
	 */
	public boolean isQueen() {
		return this.getClass().equals(piece.Queen.class);
	}
	/**
	 * @return true : this�� Rook.class�� ���
	 */
	public boolean isRook() {
		return this.getClass().equals(piece.Rook.class);
	}
	/**
	 * @return true : this�� Bishop.class�� ���
	 */
	public boolean isBishop() {
		return this.getClass().equals(piece.Bishop.class);
	}
	/**
	 * @return true : this�� Knight.class�� ���
	 */
	public boolean isKnight() {
		return this.getClass().equals(piece.Knight.class);
	}
	/**
	 * @return true : this�� Pawn.class�� ���
	 */
	public boolean isPawn() {
		return this.getClass().equals(piece.Pawn.class);
	}
	/**
	 * @return true : this�� NonePiece.class�� ���
	 */
	public boolean isNonePiece() {
		return this.getClass().equals(piece.NonePiece.class);
	}
	/**
	 * @param position  PositionŸ���� �ν��Ͻ��� ���ڷ� ����
	 * @return true : position �ν��Ͻ��� ���� x,y�� ���� 8by8 ���忡 �� ���  
	 *                position.getX() >= 0 && position.getY() >=0 && position.getX() < 8 && position.getY() < 8
	 */
	public boolean isValid(Position position) {
		if (position.getX() < 0 || position.getX() >= Board.BOARD_LINES) return false;
		if (position.getY() < 0 || position.getY() >= Board.BOARD_LINES) return false;
		return true;
	}

	
	public abstract double getPoints();
	public abstract char getRepresentation();
	public Piece.Color getColor() {
		return this.color;
	}
	
	////
	/**
	 * @return pos��ü�� x���� ��ȯ
	 */
	public int getX () {
		return pos.getX();
	}
	/**
	 * @return pos��ü�� y���� ��ȯ
	 */
	public int getY () {
		return pos.getY();
	}
	/**
	 * 
	 * @return pos ��ü�� ��ȯ
	 */
	public Position getPosition() {
		return this.pos;
	}
	/**
	 * ���ڷ� ���� position�� this.pos�� ����
	 * @param position
	 */
	public void setPosition(Position position) {
		this.pos = position;
	}

	// moves
	/**
	 * for���� �̿��� �� piece�� ����� moves�� ��ȯ�ϸ鼭
	 * king.class, knight.class, pawn.class �� ��� irregularMoves() �޼ҵ� ����
	 * queen.class, bishop.class, rook.class �� ��� regularMoves() �޼ҵ� ����
	 * @return �� piece�� ������ �� �ִ� ��ǥ�� ������ possibleMoves�� ��ȯ
	 */
	public List<Position> getPossibleMoves () {
		possibleMoves = new ArrayList<Position>();
		for (Position.Move move : moves) {
			if (this.isKing()  || this.isKnight() || this.isPawn())
				irregularMoves (pos, move); 
			else if (this.isQueen() || this.isBishop() || this.isRook())
				regularMoves (pos, move);
		}
		return possibleMoves;
	}

	//
	/**
	 * King, knight, pawn�� overriding
	 * @param position
	 * @param move
	 */
	protected void irregularMoves (Position position, Position.Move move) {};
	private   void   regularMoves (Position position, Position.Move move) {	
		int newX = position.getX() + move.getX();
		int newY = position.getY() + move.getY();
		
		if (!this.isValid( new Position(position.getX(), position.getY()))) return; // end condition
		
		putMovement (position);
		regularMoves (new Position(newX, newY), move);  //recursive call
	}
	
	/**
	 * position���� board�� ����� �� �ִ��� isValid�� ���� ��ȿ�� �˻� �� ���� ��� possibleMoves�� ����
	 * @param position
	 */
	protected void putMovement (Position position) {
		if (this.isValid(position))
			possibleMoves.add(position);
	}
	
	

}
