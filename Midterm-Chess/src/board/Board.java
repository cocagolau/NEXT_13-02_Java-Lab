package board;

import static util.Util.appendNewLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import factory.Factory;

import piece.Piece;
/**
 * 
 * @author Dec7
 *
 */
public class Board{
	// class variable
	public static final int BOARD_LINES = 8;
	private static final double POINTS_VERTICAL_PAWN = 0.5;
	
	// instance variable
	private List<Line> lines = new ArrayList<Line>(Board.BOARD_LINES);
	
	
	// instance method
	//// initialize
	/**
	 * board에 Line을 추가
	 */
	public void initialize () {		
		for (int i=0; i<Board.BOARD_LINES; i++)
			lines.add(Line.create());
	}
	
	/**
	 * chess가 시작시 기본 설정된 위치에 piece를 생성
	 */
	public void LineUp () {
		// Black
		putPiece (new Position (0,0), Factory.black(piece.Rook.class));
		putPiece (new Position (1,0), Factory.black(piece.Knight.class));
		putPiece (new Position (2,0), Factory.black(piece.Bishop.class));
		putPiece (new Position (3,0), Factory.black(piece.Queen.class));
		putPiece (new Position (4,0), Factory.black(piece.King.class));
		putPiece (new Position (5,0), Factory.black(piece.Bishop.class));
		putPiece (new Position (6,0), Factory.black(piece.Knight.class));
		putPiece (new Position (7,0), Factory.black(piece.Rook.class));
		
		putPiece (new Position (0,1), Factory.black(piece.Pawn.class));
		putPiece (new Position (1,1), Factory.black(piece.Pawn.class));
		putPiece (new Position (2,1), Factory.black(piece.Pawn.class));
		putPiece (new Position (3,1), Factory.black(piece.Pawn.class));
		putPiece (new Position (4,1), Factory.black(piece.Pawn.class));
		putPiece (new Position (5,1), Factory.black(piece.Pawn.class));
		putPiece (new Position (6,1), Factory.black(piece.Pawn.class));
		putPiece (new Position (7,1), Factory.black(piece.Pawn.class));
		
		// White
		putPiece (new Position (0,6), Factory.white(piece.Pawn.class));
		putPiece (new Position (1,6), Factory.white(piece.Pawn.class));
		putPiece (new Position (2,6), Factory.white(piece.Pawn.class));
		putPiece (new Position (3,6), Factory.white(piece.Pawn.class));
		putPiece (new Position (4,6), Factory.white(piece.Pawn.class));
		putPiece (new Position (5,6), Factory.white(piece.Pawn.class));
		putPiece (new Position (6,6), Factory.white(piece.Pawn.class));
		putPiece (new Position (7,6), Factory.white(piece.Pawn.class));
		
		putPiece (new Position (0,7), Factory.white(piece.Rook.class));
		putPiece (new Position (1,7), Factory.white(piece.Knight.class));
		putPiece (new Position (2,7), Factory.white(piece.Bishop.class));
		putPiece (new Position (3,7), Factory.white(piece.Queen.class));
		putPiece (new Position (4,7), Factory.white(piece.King.class));
		putPiece (new Position (5,7), Factory.white(piece.Bishop.class));
		putPiece (new Position (6,7), Factory.white(piece.Knight.class));
		putPiece (new Position (7,7), Factory.white(piece.Rook.class));
		
	}
	
	//// board
	private Line getLine(int index) {
		return lines.get(index);
	}
	/** 
	 * board의 상황을 출력해서 볼 수 있도록 문자열로 반환
	 * @return 각 line의 printLineByRepresentation()메소드를 실행 후 실행값을 문자열로 변환 후 반환
	 */
	public String printBoard() {
		StringBuilder board = new StringBuilder();
		for (Line line : lines)
			board.append(appendNewLine(line.printLineByRepresentation()));
		return board.toString();
	}
	private double getPoints(Class className) {
		return Factory.selectPiece(className).getPoints();
	}
	
	
	//// piece
	/**
	 * 인자로 받은 piece를 position에 저장
	 * @param position
	 * @param piece
	 */
	public void putPiece(Position position, Piece piece) {
		piece.setPosition(position);
		getLine(piece.getY()).putPieceInLine(piece.getX(), piece);
	}
	
	/**
	 * 인자로 받은 position에 해당하는 piece를 반환
	 * @param position
	 * @return 해당 위치의 piece를 반환
	 */
	public Piece getPiece(Position position) {
		return getLine(position.getY()).getPieceInLine(position.getX());
	}
	
	
	//// pieceList
	/**
	 * 해당 color의 piece를 point의 크기대로 내림차순 정렬된 결과를 반환
	 * @param color
	 * @return point크기별 정렬된 결과 반환
	 */
	public List<Piece> getSortedList(Piece.Color color) {
		List<Piece> sortedPieceList = getPieceList(color);
		Collections.sort(sortedPieceList);
		return sortedPieceList;
	}
	private List<Piece> getPieceList(Piece.Color color) {
		List<Piece> pieceList = new ArrayList<Piece>();
		for (Line line : lines)
			pieceList.addAll(line.getPieceListInLine(color));
		return pieceList;
	}
	
	////piece counter
	/**
	 * 해당 className과 color가 같은 갯수를 board에서 확인 후 반환
	 * @param className
	 * @param color
	 * @return 해당 class와 color가 동일한 갯수
	 */
	public int getCount(Class className, Piece.Color color) {
		int count = 0;
		for (Line line : lines)
			count += line.getCountInLine(className, color);
		return count;
	}
	
	private int getCountOfVerticalPawns(Piece.Color color) {
		int total = 0;
		if (getCount(piece.Pawn.class, color) < 2)
			return 1;
		
		for (int index=0; index<Board.BOARD_LINES; index++) {
			int count = 0;
			for (Line line : lines) {
				if (line.getPieceInLine(index).isPawn() && line.getPieceInLine(index).getColor().equals(color))
					count ++;
			}
			if (count > 1)
				total += count;
		}
		return total;
	}
	
	//// piece score
	/**
	 * 해당 color의 Queen, Rook, Bishop, Knight, Pawn의 score를 반환 
	 * @param color
	 * @return Queen, Rook, Bishop, Knight, Pawn의 score값을 반환
	 */
	public double getScore(Piece.Color color) {		
		return (  getScore (piece.Queen.class , color)
				+ getScore (piece.Rook.class,   color)
				+ getScore (piece.Bishop.class, color)
				+ getScore (piece.Knight.class, color)
				+ getScore (piece.Pawn.class,   color));
	}
	
	private double getScore (Class className, Piece.Color color) {
		double score = getCount(className, color) * getPoints(className);
		
		if (className.equals(piece.Pawn.class))
			return score - adjustVerticalPawn(color);
		
		return score; 
	}


	private double adjustVerticalPawn(Piece.Color color) {
		return (Board.POINTS_VERTICAL_PAWN * getCountOfVerticalPawns(color));
	}
	
}
