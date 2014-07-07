package chess;

import java.util.List;

import board.Board;
import board.Position;
import piece.Piece;


/**
 * 
 * @author Dec7
 *
 */


/**
 * chess ������ �⺻���� �������̽��� ���
 *
 */
public class Game {
	
	// instance variable
	private Board board;

	
	/**
	 * ���ο� board�� ���� �� board�� initialize() �޼ҵ带 ����
	 */
	// constructor
	public Game () {
		board = new Board();
		board.initialize();
	}
	
	/**
	 * board �ν��Ͻ��� lineUp() �޼ҵ带 ����
	 */
	public void LineUp() {
		board.LineUp();
	}
	
	
	// instance method
	////board
	/**
	 * 
	 * @return game�� ������ Board�� �ν��Ͻ��� ��ȯ
	 */
	public Board getBoard() {
		return this.board;
	}
	/**
	 * board ��ü�� printBoard()�޼ҵ带 ���� �� �� ������� ��ȯ
	 * @return board.printBoard()
	 */
	public String printBoard() {
		return board.printBoard();
	}
	/**
	 * �ش� color�� Piece�� ���ĵ� ���·� ��ȯ
	 * @param color
	 * @return board.getSoredList(color)�� ���� �� ����� ��ȯ
	 */
	public List<Piece> getSortedList(Piece.Color color) {
		return this.board.getSortedList(color);
	}

	
	//// piece
	/**
	 * String�� code���� Piece�� piece�� ��Ƽ� �ش� ��ġ�� piece�� ���� 
	 * @param code
	 * @param piece
	 */
	public void put(String code, Piece piece) {
		board.putPiece(new Position(code), piece);
	}
	/**
	 * 
	 * @param code
	 * @return �ش� code�� ��ġ�� piece�� ��ȯ
	 */
	public Piece get(String code) {
		return this.board.getPiece(new Position(code));
	}
	private Piece get(Position position) {
		return this.board.getPiece(position);
	}
	/**
	 * �ش� class�� color�� �ش��ϴ� ������ ��ȯ
	 * @param className
	 * @param color
	 * @return board��ü�� getCount(className, color)�� ���� �� ������� ��ȯ
	 */
	public int getCount(Class className, Piece.Color color) {
		return this.board.getCount(className, color);
	}
	
	/**
	 * ���� ��ġ�� ���� �̵��ϰ��� �ϴ� ������ �̵�
	 * beforeCode�� ���� piece�� �� �� �ִ� ���� possibleMoves�� ����
	 * afterCode�� �ش��ϴ� ���� �ִ� ��� ��ȯ
	 * @param beforeCode
	 * @param afterCode
	 */
	public void movePiece(String beforeCode, String afterCode) {
		Piece beforePiece = get(beforeCode);
		List<Position> possibleMoves = beforePiece.getPossibleMoves();
		
		Position afterPosition = new Position(afterCode);
		for (Position position : possibleMoves) {
			if (position.getX() == afterPosition.getX() && position.getY() == afterPosition.getY()) {
				put (beforeCode, get(afterCode));
				put (afterCode, beforePiece);
			}
		}
	}
	
	
	////piece scorer
	/**
	 * @return getScore(Piece.Color.BLACK) ���� �� ��� �� ��ȯ
	 */
	public double getBlackScore() {
		return getScore(Piece.Color.BLACK);
	}
	/**
	 * @return getScore(Piece.Color.WHITE) ���� �� ��� �� ��ȯ
	 */
	public double getWhiteScore() {
		 return getScore(Piece.Color.WHITE);
	}
	private double getScore(Piece.Color color) {
		return  this.board.getScore(color);
	}

	

	// getPossibleMoves
	/**
	 * code�� �ִ� piece�� �� �� �ִ� ��ġ�� possibleMoves�� ���� ��
	 * NonePiece.class�� �ƴ� ��� ����
	 * @param code
	 * @return piece�� ������ �� �� �ִ� ������ ��ȯ
	 */
	public List<Position> getPossibleMoves(String code) {
		List<Position> possibleMoves = get(code).getPossibleMoves();
		Piece tempPiece;
		
		for (int i=0; i<possibleMoves.size(); i++) {
			tempPiece = get(possibleMoves.get(i));
			
			if (!tempPiece.isNonePiece()) {
				possibleMoves.remove(i);
				i--;
			}
		}
		return possibleMoves;
	}
}
