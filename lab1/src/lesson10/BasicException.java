package lesson10;

public class BasicException {
	
	public static void main (String args[]) {
		try {
			int[] ar = new int[]{0,100,200,300};
			for (int i=0; i<ar.length+1; i++)
				System.out.println ("i: " + i + ", value: " + ar[i]);
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println ("e.getMessage(): " + e.getMessage());
			System.out.println ("e.toString(): " + e.toString());
			e.printStackTrace();
			return;
			
		} finally {
			System.out.println ("finally: here");
		}
	}

}
