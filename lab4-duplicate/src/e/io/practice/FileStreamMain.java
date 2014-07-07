package e.io.practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileStreamMain {
	
//	public static void main (String[] args) throws IOException{
//		int i;
//		System.out.println ("press the end button");
//		InputStreamReader irs = new InputStreamReader (System.in);
//		
//		while ((i=irs.read()) != '³¡')
//			System.out.print((char)i);
//	}
	
	public static void main (String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream ("a.txt", true);
		fos.write(72);
		fos.write(101);
		fos.write(108);
		fos.write(108);
		fos.write(111);
		fos.close();
		System.out.println("end");
		
		
	}

}
