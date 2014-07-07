package factory;

import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.Queen;
import piece.Rook;
import piece.Piece.Color;

public class Factory {
	
	// private constructor
	private Factory() {};
	
	// factory class
	/**
	 * @param className
	 * @return className에 해당된 white piece를 생성하는 factory 메소드
	 */
	public static Piece white (Class className) {
		Piece.Color color = Piece.Color.WHITE;			
		return selectPiece (className, color);
	}

	/**
	 * @param className
	 * @return className에 해당된 black piece를 생성하는 factory 메소드
	 */
	public static Piece black (Class className) {
		Piece.Color color = Piece.Color.BLACK;
		return selectPiece (className, color);
	}
	
	public static Piece selectPiece (Class className) {
		return selectPiece (className, Color.WHITE);
	}
	
	private static Piece selectPiece(Class className, Color color) {
		Piece newPiece = null;
		
		if (className.equals(piece.King.class))
			newPiece = new King (color);
		else if (className.equals(piece.Queen.class))
			newPiece = new Queen (color);
		else if (className.equals(piece.Rook.class))
			newPiece = new Rook (color);
		else if (className.equals(piece.Bishop.class))
			newPiece = new Bishop (color);
		else if (className.equals(piece.Knight.class))
			newPiece = new Knight (color);
		else if (className.equals(piece.Pawn.class))
			newPiece = new Pawn (color);
		
		return newPiece;
	}
	
}
