package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class NewFileCopy {
	
	public static void main (String[] args) throws IOException {
		
		String beforePath = "C:\\test\\A\\re.pptx";
		String afterPath = "C:\\test\\B";
//		String fileName = "test.txt";
		
		File file = new File(beforePath);
		
		BufferedInputStream bis = new BufferedInputStream (new FileInputStream (beforePath));
		BufferedOutputStream bos = new BufferedOutputStream (new FileOutputStream (afterPath+File.separator+file.getName()));
		int i;
		while ( (i=bis.read()) != -1)
			bos.write(i);
		
		System.out.println ("success");
		
		bos.close();
		bis.close();
		
		
	}

}
