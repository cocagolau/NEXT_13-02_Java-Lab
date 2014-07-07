package e.io.practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream4 {
	
	public static void main (String[] args) throws IOException {
	
		FileInputStream fis = null;
//		BufferedInputStream bis = null;
		FileOutputStream fos = null;
//		BufferedOutputStream bos = null;
		
		fis = new FileInputStream("re.pptx");
		fos = new FileOutputStream("rrre.pptx");
		
//		bis = new BufferedInputStream(new FileInputStream("re.pptx"));
//		bos = new BufferedOutputStream (new FileOutputStream("rrre.pptx"));
		
		int i;
		long start = System.currentTimeMillis();
		
		while ( (i=fis.read()) != -1) {
//			System.out.print((char)i);
			fos.write (i);
		}
		long elapsed = System.currentTimeMillis() - start;
		System.out.println ("success : " + elapsed);
		
		fos.close();
		fis.close();
			
	}

}
