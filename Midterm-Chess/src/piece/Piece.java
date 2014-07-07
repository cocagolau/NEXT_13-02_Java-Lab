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
	 * Comparable 인터페이스에 정의되어있는 compareTo메소드
	 * @param that	Piece타입
	 * @return -1 : 자기 인스턴스의 getPoints()값보다 인자로 받은 Piece인스턴스의 getPoints() 값이 클경우
	 *          0 : 갈을 경우
	 *          1 : 작은경우
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
	 * this객체의 상태를 boolean값으로 반환
	 * @return true : this의 color변수의 값이 WHITE일때
	 */
	public boolean isWhite() {
		return this.color.equals(Piece.Color.WHITE);
	}
	/**
	 * @return true : this의 color변수의 값이 BLACKE일때
	 */
	public boolean isBlack() {
		return this.color.equals(Piece.Color.BLACK);
	}
	/**
	 * @return true : this가 King.class인 경우
	 */
	public boolean isKing() {
		return this.getClass().equals(piece.King.class);
	}
	/**
	 * @return true : this가 Queen.class인 경우
	 */
	public boolean isQueen() {
		return this.getClass().equals(piece.Queen.class);
	}
	/**
	 * @return true : this가 Rook.class인 경우
	 */
	public boolean isRook() {
		return this.getClass().equals(piece.Rook.class);
	}
	/**
	 * @return true : this가 Bishop.class인 경우
	 */
	public boolean isBishop() {
		return this.getClass().equals(piece.Bishop.class);
	}
	/**
	 * @return true : this가 Knight.class인 경우
	 */
	public boolean isKnight() {
		return this.getClass().equals(piece.Knight.class);
	}
	/**
	 * @return true : this가 Pawn.class인 경우
	 */
	public boolean isPawn() {
		return this.getClass().equals(piece.Pawn.class);
	}
	/**
	 * @return true : this가 NonePiece.class인 경우
	 */
	public boolean isNonePiece() {
		return this.getClass().equals(piece.NonePiece.class);
	}
	/**
	 * @param position  Position타입의 인스턴스를 인자로 받음
	 * @return true : position 인스턴스의 변수 x,y의 값이 8by8 보드에 들어갈 경우  
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
	 * @return pos객체의 x값을 반환
	 */
	public int getX () {
		return pos.getX();
	}
	/**
	 * @return pos객체의 y값을 반환
	 */
	public int getY () {
		return pos.getY();
	}
	/**
	 * 
	 * @return pos 객체를 반환
	 */
	public Position getPosition() {
		return this.pos;
	}
	/**
	 * 인자로 받은 position을 this.pos에 저장
	 * @param position
	 */
	public void setPosition(Position position) {
		this.pos = position;
	}

	// moves
	/**
	 * for문을 이용해 각 piece에 저장된 moves를 순환하면서
	 * king.class, knight.class, pawn.class 일 경우 irregularMoves() 메소드 실행
	 * queen.class, bishop.class, rook.class 일 경우 regularMoves() 메소드 실행
	 * @return 각 piece가 움직일 수 있는 좌표를 저장한 possibleMoves를 반환
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
	 * King, knight, pawn에 overriding
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
	 * position값이 board에 저장될 수 있는지 isValid를 통해 유효성 검사 후 참일 경우 possibleMoves에 저장
	 * @param position
	 */
	protected void putMovement (Position position) {
		if (this.isValid(position))
			possibleMoves.add(position);
	}
	
	

}
