package board;

import java.util.ArrayList;

import factory.Factory;

import board.Board;
import board.Line;

import junit.framework.TestCase;
import piece.King;
import piece.Pawn;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class LineTest extends TestCase {

	Line lineOfwPawn;
	Line lineOfbPawn;
	Line line;
	ArrayList<Piece> lineOfPawns;
	String testP = "pppppppp";
	String testCapitalP = "PPPPPPPP";
	
	public void setUp () {
		line = Line.create();
		lineOfwPawn = Line.create();
		lineOfbPawn = Line.create();
	}
	
	public void testLine () {	
		for (int i = 0; i<Board.BOARD_LINES; i++) {
			lineOfwPawn.putPieceInLine(i, Factory.white(piece.Pawn.class));
			lineOfbPawn.putPieceInLine(i, Factory.black(piece.Pawn.class));
		}
		
		assertEquals (testCapitalP, lineOfbPawn.printLineByRepresentation());
		assertEquals (testP, lineOfwPawn.printLineByRepresentation());
	}
	
	public void testCount() {
		line.putPieceInLine (0, Factory.white(piece.King.class));
		line.putPieceInLine (1, Factory.black(piece.Pawn.class));
		line.putPieceInLine (2, Factory.black(piece.King.class));
		line.putPieceInLine (3, Factory.black(piece.Queen.class));
		line.putPieceInLine (4, Factory.white(piece.Pawn.class));
		line.putPieceInLine (5, Factory.white(piece.Rook.class));
		line.putPieceInLine (6, Factory.black(piece.Pawn.class));
	
		assertEquals (2, line.getCountInLine(piece.Pawn.class, Piece.Color.BLACK));
		assertEquals ('k', line.getPieceInLine(0).getRepresentation());
	}

}
