package board;

import java.util.ArrayList;
import java.util.List;

import piece.NonePiece;
import piece.Piece;
import static util.Util.NEWPOINT;

public class Line {
	private static int numOfPieces = 0;
	private List<Piece> line = new ArrayList<Piece>(Board.BOARD_LINES);
	private Piece nonePiece = NonePiece.getInstance();
	
	// factory method
	public static Line create() {
		return new Line();
	}
	
	// private constructor
	private Line () {
		initLine();
	}
	
	// class method
	public static int getNumOfPiece () {
		return Line.numOfPieces;
	}
	
	// instance method
	/**
	 * 각 line마다 nonePiece를 8개 저장하여 초기화
	 */
	private void initLine () {
		for (int i=0; i<Board.BOARD_LINES; i++)
			this.line.add (this.nonePiece);	
	}

	/**
	 * 해당 index에 piece를 저장
	 * @param index
	 * @param piece
	 */
	public void putPieceInLine(int index, Piece piece) {
		this.line.set(index, piece);
	}
	
	/**
	 * @param index
	 * @return 해당 index에 해당된 piece를 찾고 반환
	 */
	public Piece getPieceInLine (int index) {
		return line.get(index);
	}
	
	/**
	 * line을 출력 가능하도록 string형으로 반환
	 * @return 각 piece의 representation값을 문자열로 묶은 뒤 반환
	 */
	public String printLineByRepresentation() {
		StringBuilder sb = new StringBuilder();
		for (Piece piece : line) {
			if (piece.isNonePiece())
				sb.append(NEWPOINT);
			else
				sb.append(piece.getRepresentation());
		}
		return sb.toString();
	}
	
	/**
	 * @param className
	 * @param color
	 * @return 해당 line에서 color와 className이 동일한 piece의 갯수를 반환
	 */
	public int getCountInLine(Class className, Piece.Color color) {
		int count=0;
		for (Piece piece : line) {
			if (piece.getClass().equals(className) && piece.getColor().equals(color))
				count++;
		}
		return count;
	}

	/**
	 * @param color
	 * @return line의 piece를 ArrayList에 담아 반환
	 */
	public List<Piece> getPieceListInLine(Piece.Color color) {
		List<Piece> pieceListInLine = new ArrayList<Piece>();
		for (Piece piece : line) {
			if (piece.getColor() == color)
				pieceListInLine.add(piece);
		}
		return pieceListInLine;
	}

}
