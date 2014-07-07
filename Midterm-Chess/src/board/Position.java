package board;

/**
 * 
 * @author Dec7
 *
 */

public class Position {

	// class variable
	public static final int code1stValue = 'a';
	public static final int code2ndValue = '1';
	
	/**
	 * �� piece�� �����̵����� ��θ� ����ϱ� ���� enum ����
	 * @author Dec7
	 *
	 */
	public enum Move {
		NW(-1,1), N(0,1), NE(1,1), W(-1,0), E(1,0), SW(-1,-1), S(0,-1), SE(1,-1);
		private int x;
		private int y;
		
		Move (int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}
	
	
	// instance variable
	private int x;
	private int y;

	// constructor
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Position(String code) {
		this.x = transfer1stCode(code.charAt(0));
		this.y = transfer2ndCode(code.charAt(1));
	}
	

	// instance method
	/**
	 * @return position�� x�� ��ȯ
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * @return position�� y�� ��ȯ
	 */
	public int getY() {
		return this.y;
	}
	
	//// interpreter
	private int transfer1stCode (char codeValue) {
		return ((int)codeValue - Position.code1stValue);
	}
	private int transfer2ndCode (char codeValue) {
		return ((int)codeValue - Position.code2ndValue);
	}

}
