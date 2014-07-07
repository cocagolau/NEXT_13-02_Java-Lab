package lesson12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	
	public static void main (String[] args) throws IOException {
		
		int i, len=0;
		
		FileInputStream fis = new FileInputStream("cccc.pdf");
		FileOutputStream fos = new FileOutputStream("dddd.pdf");
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		long psecond = System.currentTimeMillis();
		
		while ((i=bis.read()) != -1) {
			bos.write(i);
			len ++;
		}
		
		bis.close();
		bos.close();
		psecond = System.currentTimeMillis() - psecond;
		System.out.println (len + " bytes, " + psecond + " miliseconds");
	}

}
