package e.io.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFile {

	public static void main (String[] args) {	
		ScannerFile readFile = new ScannerFile();
		String fullPath = "C:\\"+"basicjava"+File.separator+"text"+File.separator+"numbers.txt";
		readFile.readWithScanner(fullPath);
	}
	
	public void readWithScanner (String fileName) {
		File file = new File (fileName);
		Scanner scan = null;
		
		try {
			scan = new Scanner(file);
			
			while (scan.hasNextLine())
				System.out.println (scan.nextLine());
			
			System.out.println ("success");
		
		}
		catch (FileNotFoundException fnfe) { fnfe.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
		finally {
			if (scan != null)
				scan.close();
		}
		
		
	}
}
