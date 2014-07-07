package chess;

import static util.Util.appendNewLine;

import java.util.ArrayList;
import java.util.List;

import piece.Piece;

import chess.Game;
import factory.Factory;

import board.Board;

import junit.framework.TestCase;

public class GameTest extends TestCase{
	
	Game game;
	Board board;
	
	List<String> b1, c1, a2, c2, d2, b3, e3;
	List<String> f5, g5, f6, h6, f7, g7, e8, f8;
	
	
	public void setUp () {		
		game = new Game();
		gameInit();
	}
	private void gameInit () {
		//black
		game.put("b1", Factory.black(piece.King.class));
		game.put("c1", Factory.black(piece.Rook.class));
		game.put("a2", Factory.black(piece.Pawn.class));
		game.put("c2", Factory.black(piece.Pawn.class));
		game.put("d2", Factory.black(piece.Bishop.class));
		game.put("b3", Factory.black(piece.Pawn.class));
		game.put("e3", Factory.black(piece.Queen.class));
		//white
		game.put("f5", Factory.white(piece.Knight.class));
		game.put("g5", Factory.white(piece.Queen.class));
		game.put("f6", Factory.white(piece.Pawn.class));
		game.put("h6", Factory.white(piece.Pawn.class));
		game.put("f7", Factory.white(piece.Pawn.class));
		game.put("g7", Factory.white(piece.Pawn.class));
		game.put("e8", Factory.white(piece.Rook.class));
		game.put("f8", Factory.white(piece.King.class));
	}
	public void testCreateBoardInit() {
		String[] line = {".KR.....", "P.PB....", ".P..Q...", "........", ".....nq.", ".....p.p", ".....pp.", "....rk..",};
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<Board.BOARD_LINES; i++)
			sb.append(appendNewLine(line[i]));
		assertEquals (sb.toString(), game.printBoard());
		System.out.println(game.printBoard());
	}
	
	// p232, 6-6
	public void testPossibleMovesOfKing() {
		Piece blackKing = game.get("b1");
		assertEquals (piece.King.class, blackKing.getClass());
		assertEquals (Piece.Color.BLACK, blackKing.getColor());
		assertEquals (2, game.getPossibleMoves("b1").size());
		
	}
	
	public void testPossibleMoves() {
		
		// black
		assertEquals (2, game.getPossibleMoves("b1").size());
		assertEquals (12, game.getPossibleMoves("c1").size());
		assertEquals (2, game.getPossibleMoves("a2").size());
		assertEquals (3, game.getPossibleMoves("c2").size());
		assertEquals (5, game.getPossibleMoves("d2").size());
		assertEquals (4, game.getPossibleMoves("b3").size());
		assertEquals (19, game.getPossibleMoves("e3").size());
		
		// white
		assertEquals (5, game.getPossibleMoves("f5").size());
		assertEquals (16, game.getPossibleMoves("g5").size());
		assertEquals (2, game.getPossibleMoves("f6").size());
		assertEquals (2, game.getPossibleMoves("h6").size());
		assertEquals (2, game.getPossibleMoves("f7").size());
		assertEquals (1, game.getPossibleMoves("g7").size());
		assertEquals (12, game.getPossibleMoves("e8").size());
		assertEquals (2, game.getPossibleMoves("f8").size());	
	}
	
	public void testCoordi() {
		gameInit();
		assertEquals (piece.King.class, game.get("b1").getClass());
		assertEquals (piece.Rook.class, game.get("c1").getClass());
		assertEquals (piece.Pawn.class, game.get("a2").getClass());
		assertEquals (piece.Pawn.class, game.get("c2").getClass());
		assertEquals (piece.Bishop.class, game.get("d2").getClass());
		assertEquals (piece.Pawn.class, game.get("b3").getClass());
		assertEquals (piece.Queen.class, game.get("e3").getClass());
		
		assertEquals (piece.Knight.class, game.get("f5").getClass());
		assertEquals (piece.Queen.class, game.get("g5").getClass());
		assertEquals (piece.Pawn.class, game.get("f6").getClass());
		assertEquals (piece.Pawn.class, game.get("h6").getClass());
		assertEquals (piece.Pawn.class, game.get("f7").getClass());
		assertEquals (piece.Pawn.class, game.get("g7").getClass());
		assertEquals (piece.Rook.class, game.get("e8").getClass());
		assertEquals (piece.King.class, game.get("f8").getClass());
	}
	
	
	
	public void testCount () {
		gameInit();
		assertEquals (3, game.getCount(piece.Pawn.class, Piece.Color.BLACK));
		assertEquals (4, game.getCount(piece.Pawn.class, Piece.Color.WHITE));
	}
	
	
	public void testScore () {
		gameInit();
		assertEquals (20.0, game.getBlackScore());
		assertEquals (19.5, game.getWhiteScore());
	}
	
	public void testSort () {
		gameInit();
		List<Piece> whitePieceList, blackPieceList;
		whitePieceList = game.getSortedList(Piece.Color.WHITE);
		blackPieceList = game.getSortedList(Piece.Color.BLACK);
		
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

	

	public void testMove() {
		gameInit();
		Piece bK = game.get("b1");
		
		System.out.println (game.printBoard());
		System.out.println ("---------------");
		game.movePiece("b1", "b2");
		assertEquals (game.get("b2"), bK);
		System.out.println (game.printBoard());
	}


}
