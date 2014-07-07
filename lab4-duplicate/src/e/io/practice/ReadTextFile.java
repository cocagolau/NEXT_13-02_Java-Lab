package e.io.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

	public static void main (String[] args) {	
		ReadTextFile readFile = new ReadTextFile();
		String fullPath = "C:\\"+"basicjava"+File.separator+"text"+File.separator+"numbers.txt";
		readFile.read(fullPath);
	}
	
	public void read(String fileName) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader (fileReader);
			
			String line;
			
			while ( (line=bufferedReader.readLine()) != null)
				System.out.println (line);
			
			System.out.println ("Read complete");
		}
		catch (IOException ioe) { ioe.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
		finally {
		
			if (bufferedReader != null) {
				try { bufferedReader.close(); }
				catch (IOException ioe) { ioe.printStackTrace(); }
			}
			
			if (fileReader != null) {
				try { fileReader.close(); }
				catch (IOException ioe) { ioe.printStackTrace(); }
			}	

		}
		
	}
	
	
}
