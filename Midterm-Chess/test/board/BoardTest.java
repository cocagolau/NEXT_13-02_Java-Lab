package board;

import java.util.List;

import piece.Piece;
import factory.Factory;
import board.Board;
import board.Position;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	
	Board board;
	
	public void setUp () {
		board = new Board();
		board.initialize();
	}
	
	// p197, 5-4
	public void testCount () {
		boardInit();
		assertEquals (3, board.getCount(piece.Pawn.class, Piece.Color.BLACK));
	}
	
	// p197, 5-5
	public void testLineUp() {
		board.LineUp();
		System.out.println (board.printBoard());
		Piece piece1 = board.getPiece(new Position ("a1"));
		assertEquals (Piece.Color.BLACK, piece1.getColor());
		assertEquals (piece.Rook.class, piece1.getClass());
		
		Piece piece2 = board.getPiece(new Position ("e8"));
		assertEquals (Piece.Color.WHITE, piece2.getColor());
		assertEquals (piece.King.class, piece2.getClass());
	}
	
	// p198, 5-7
	public void testScore () {
		boardInit();
		assertEquals (20.0, board.getScore (Piece.Color.BLACK));
		assertEquals (19.5, board.getScore (Piece.Color.WHITE));
		
	}
	
	// p198, 5-8
	public void testSort () {
		boardInit();
		List<Piece> whitePieceList, blackPieceList;
		whitePieceList = board.getSortedList(Piece.Color.WHITE);
		blackPieceList = board.getSortedList(Piece.Color.BLACK);
		
		// black
		assertEquals ('K', blackPieceList.get(0).getRepresentation());
		assertEquals ('Q', blackPieceList.get(1).getRepresentation());
		assertEquals ('R', blackPieceList.get(2).getRepresentation());
		assertEquals ('B', blackPieceList.get(3).getRepresentation());
		assertEquals ('P', blackPieceList.get(4).getRepresentation());
		assertEquals ('P', blackPieceList.get(5).getRepresentation());
		assertEquals ('P', blackPieceList.get(6).getRepresentation());
		
		// white
		assertEquals ('k', whitePieceList.get(0).getRepresentation());
		assertEquals ('q', whitePieceList.get(1).getRepresentation());
		assertEquals ('r', whitePieceList.get(2).getRepresentation());
		assertEquals ('n', whitePieceList.get(3).getRepresentation());
		assertEquals ('p', whitePieceList.get(4).getRepresentation());
		assertEquals ('p', whitePieceList.get(5).getRepresentation());
		assertEquals ('p', whitePieceList.get(6).getRepresentation());
		assertEquals ('p', whitePieceList.get(7).getRepresentation());
		
	}
	
	
	public void boardInit () {
		//black
		board.putPiece (new Position (1, 0), Factory.black(piece.King.class));
		board.putPiece (new Position (2, 0), Factory.black(piece.Rook.class));
		board.putPiece (new Position (0, 1), Factory.black(piece.Pawn.class));
		board.putPiece (new Position (2, 1), Factory.black(piece.Pawn.class));
		board.putPiece (new Position (3, 1), Factory.black(piece.Bishop.class));
		board.putPiece (new Position (1, 2), Factory.black(piece.Pawn.class));
		board.putPiece (new Position (4, 2), Factory.black(piece.Queen.class));
		//white
		board.putPiece (new Position (5, 4), Factory.white(piece.Knight.class));
		board.putPiece (new Position (6, 4), Factory.white(piece.Queen.class));
		board.putPiece (new Position (5, 5), Factory.white(piece.Pawn.class));
		board.putPiece (new Position (7, 5), Factory.white(piece.Pawn.class));
		board.putPiece (new Position (5, 6), Factory.white(piece.Pawn.class));
		board.putPiece (new Position (6, 6), Factory.white(piece.Pawn.class));
		board.putPiece (new Position (4, 7), Factory.white(piece.Rook.class));
		board.putPiece (new Position (5, 7), Factory.white(piece.King.class));
		
	}

}
















