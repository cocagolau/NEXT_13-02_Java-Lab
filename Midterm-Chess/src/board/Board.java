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
	 * board�� Line�� �߰�
	 */
	public void initialize () {		
		for (int i=0; i<Board.BOARD_LINES; i++)
			lines.add(Line.create());
	}
	
	/**
	 * chess�� ���۽� �⺻ ������ ��ġ�� piece�� ����
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
	 * board�� ��Ȳ�� ����ؼ� �� �� �ֵ��� ���ڿ��� ��ȯ
	 * @return �� line�� printLineByRepresentation()�޼ҵ带 ���� �� ���ప�� ���ڿ��� ��ȯ �� ��ȯ
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
	 * ���ڷ� ���� piece�� position�� ����
	 * @param position
	 * @param piece
	 */
	public void putPiece(Position position, Piece piece) {
		piece.setPosition(position);
		getLine(piece.getY()).putPieceInLine(piece.getX(), piece);
	}
	
	/**
	 * ���ڷ� ���� position�� �ش��ϴ� piece�� ��ȯ
	 * @param position
	 * @return �ش� ��ġ�� piece�� ��ȯ
	 */
	public Piece getPiece(Position position) {
		return getLine(position.getY()).getPieceInLine(position.getX());
	}
	
	
	//// pieceList
	/**
	 * �ش� color�� piece�� point�� ũ���� �������� ���ĵ� ����� ��ȯ
	 * @param color
	 * @return pointũ�⺰ ���ĵ� ��� ��ȯ
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
	 * �ش� className�� color�� ���� ������ board���� Ȯ�� �� ��ȯ
	 * @param className
	 * @param color
	 * @return �ش� class�� color�� ������ ����
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
	 * �ش� color�� Queen, Rook, Bishop, Knight, Pawn�� score�� ��ȯ 
	 * @param color
	 * @return Queen, Rook, Bishop, Knight, Pawn�� score���� ��ȯ
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
