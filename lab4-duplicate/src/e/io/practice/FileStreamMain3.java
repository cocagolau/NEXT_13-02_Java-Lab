package e.io.practice;

import java.io.FileInputStream;
import java.io.IOException;

public class FileStreamMain3 {
	
	public static void main (String[] args) throws IOException{
		FileInputStream fis = null;
		fis = new FileInputStream ("a.txt");
		
		int i=0;
		while ((i=fis.read()) != -1)
			System.out.println ((char)i);
		
		if (fis != null)
			fis.close();
		
	}

}
