package lesson10;

public class UseThrowMain {
	
	public static void main (String arg[]) {
		try{
			throw new Exception ("this is an error message");
			
		}catch(Exception e) {
			System.out.println ("-- Exception --");
			System.out.println ("e.getMessage(): " + e.getMessage());
			System.out.println ("e.toString(): " + e.toString());
			e.printStackTrace();
			return;
			
		}finally {
			System.out.println ("finally : here");
			
		}
	}

}
