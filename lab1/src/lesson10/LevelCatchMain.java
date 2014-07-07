package lesson10;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LevelCatchMain {
	
	public static void main (String args[]) {
		try {
			FileReader f = new FileReader ("LevelCatchMain.java");
			String s = null;
			System.out.println (s.toString());
			
		}catch(FileNotFoundException e1) {
			System.out.println ("FileNotException : " + e1);
			
		}catch(ArrayIndexOutOfBoundsException e2) {
			System.out.println ("ArrayIndexOutOfBoundsException : " + e2);
			
		}catch(Exception e) {
			System.out.println ("Exception : " + e);
		}
	}

}
