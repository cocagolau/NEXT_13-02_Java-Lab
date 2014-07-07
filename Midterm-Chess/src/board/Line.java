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
	 * �� line���� nonePiece�� 8�� �����Ͽ� �ʱ�ȭ
	 */
	private void initLine () {
		for (int i=0; i<Board.BOARD_LINES; i++)
			this.line.add (this.nonePiece);	
	}

	/**
	 * �ش� index�� piece�� ����
	 * @param index
	 * @param piece
	 */
	public void putPieceInLine(int index, Piece piece) {
		this.line.set(index, piece);
	}
	
	/**
	 * @param index
	 * @return �ش� index�� �ش�� piece�� ã�� ��ȯ
	 */
	public Piece getPieceInLine (int index) {
		return line.get(index);
	}
	
	/**
	 * line�� ��� �����ϵ��� string������ ��ȯ
	 * @return �� piece�� representation���� ���ڿ��� ���� �� ��ȯ
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
	 * @return �ش� line���� color�� className�� ������ piece�� ������ ��ȯ
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
	 * @return line�� piece�� ArrayList�� ��� ��ȯ
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
