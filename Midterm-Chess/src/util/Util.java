package util;

import board.Board;
import board.Position;


public class Util {
//	public static final String NEWLINE = System.getProperty("line.separator");
	public static final char NEWLINE = '\n';
	public static final char NEWTAP = '\t';
	public static final char NEWSPACE = ' ';
	public static final char NEWPOINT = '.';
		
	private Util () {}
	
	public static String appendNewLine (String string) {
		return string + Util.NEWLINE; 
	}

	public static String appendNewTap(String string) {
		return string + Util.NEWTAP; 
	}
	
	public static String appendNewSpace(String string) {
		return string + Util.NEWSPACE; 
	}
	
	
	// class method
	/**
	 * 
	 * @param position
	 * @return position의 좌표값을 Code로 변환
	 */
	public static String getCode (Position position) {
		int x = position.getX();
		int y = position.getY();
		
		if (x<0 || x>=Board.BOARD_LINES) return null;
		if (y<0 || y>=Board.BOARD_LINES) return null;
		
		int frontCodeValue = x + Position.code1stValue;
		int rearCodeValue  = y + Position.code2ndValue;
		return Character.toString((char)frontCodeValue)
			 + Character.toString((char)rearCodeValue );
	}
	
	/**
	 * @param num
	 * @return num*2
	 */
	public static int doubleMove (int num) {		
		return num*2;
	}
	
}
