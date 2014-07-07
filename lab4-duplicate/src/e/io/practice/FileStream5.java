package e.io.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream5 {
	
	public static void main (String[] args) throws IOException {
		
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		
		fos = new FileOutputStream("test.txt");
		fos.write(100);
		fos.write('A');
		fos.write(144);
		fos.close();
		
		fis = new FileInputStream("test.txt");
		int i;
		int total = 0;
		while ( (i=fis.read()) != -1) {
			total += i;
			System.out.println (i);
		}

		System.out.println ("Success : " + total);
		
	}

}
