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
 * chess 게임의 기본적인 인터페이스를 담당
 *
 */
public class Game {
	
	// instance variable
	private Board board;

	
	/**
	 * 새로운 board를 생성 후 board의 initialize() 메소드를 실행
	 */
	// constructor
	public Game () {
		board = new Board();
		board.initialize();
	}
	
	/**
	 * board 인스턴스의 lineUp() 메소드를 실행
	 */
	public void LineUp() {
		board.LineUp();
	}
	
	
	// instance method
	////board
	/**
	 * 
	 * @return game에 생성된 Board의 인스턴스를 반환
	 */
	public Board getBoard() {
		return this.board;
	}
	/**
	 * board 객체의 printBoard()메소드를 실행 후 그 결과값을 반환
	 * @return board.printBoard()
	 */
	public String printBoard() {
		return board.printBoard();
	}
	/**
	 * 해당 color의 Piece를 정렬된 상태로 반환
	 * @param color
	 * @return board.getSoredList(color)를 실행 후 결과값 반환
	 */
	public List<Piece> getSortedList(Piece.Color color) {
		return this.board.getSortedList(color);
	}

	
	//// piece
	/**
	 * String형 code값과 Piece형 piece를 방아서 해당 위치에 piece를 저장 
	 * @param code
	 * @param piece
	 */
	public void put(String code, Piece piece) {
		board.putPiece(new Position(code), piece);
	}
	/**
	 * 
	 * @param code
	 * @return 해당 code에 위치한 piece를 반환
	 */
	public Piece get(String code) {
		return this.board.getPiece(new Position(code));
	}
	private Piece get(Position position) {
		return this.board.getPiece(position);
	}
	/**
	 * 해당 class의 color에 해당하는 갯수를 반환
	 * @param className
	 * @param color
	 * @return board객체의 getCount(className, color)를 실행 후 결과값을 반환
	 */
	public int getCount(Class className, Piece.Color color) {
		return this.board.getCount(className, color);
	}
	
	/**
	 * 이전 위치의 말을 이동하고자 하는 곳으로 이동
	 * beforeCode에 위한 piece가 갈 수 있는 곳을 possibleMoves에 저장
	 * afterCode에 해당하는 값이 있는 경우 교환
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
	 * @return getScore(Piece.Color.BLACK) 실행 후 결과 값 반환
	 */
	public double getBlackScore() {
		return getScore(Piece.Color.BLACK);
	}
	/**
	 * @return getScore(Piece.Color.WHITE) 실행 후 결과 값 반환
	 */
	public double getWhiteScore() {
		 return getScore(Piece.Color.WHITE);
	}
	private double getScore(Piece.Color color) {
		return  this.board.getScore(color);
	}

	

	// getPossibleMoves
	/**
	 * code에 있는 piece가 갈 수 있는 위치를 possibleMoves에 저장 후
	 * NonePiece.class가 아닐 경우 삭제
	 * @param code
	 * @return piece가 실제로 갈 수 있는 공간을 반환
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
