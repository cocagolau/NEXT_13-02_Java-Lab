package lesson12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamMain {
	
	public static void main (String[] args) throws IOException {
//		FileOutputStream fos = new FileOutputStream ("a.txt", true);
//		fos.white('H');
//		fos.white('E');
//		fos.white('L');
//		fos.white('L');
//		fos.white('O');
//		fos.close();
//		System.out.println ("a.txt end");
//		
		FileInputStream fis = new FileInputStream("a.txt");
		int i;
		while ((i=fis.read()) != -1) {
			System.out.print ((char)i);
		}
		fis.close();
		System.out.println();
	}

}
