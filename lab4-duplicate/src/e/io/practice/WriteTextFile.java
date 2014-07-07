package e.io.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile {
	
	public static void main (String[] args) {
		WriteTextFile manager = new WriteTextFile();
		int numberCount = 10;
		
		String fullPath = "C:\\"+"basicjava"+File.separator+"text"+File.separator+"numbers.txt";
		manager.writeFile(fullPath, numberCount);
	}
	
	public void writeFile (String fileName, int numberCount) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			for (int i=0 ; i<=numberCount; i++) {
				bufferedWriter.write(Integer.toString(i));
				bufferedWriter.newLine();
			}
			System.out.println ("complete");
			
		}
		catch (IOException ioe) { ioe.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
		finally {
			if (bufferedWriter != null) {
				try { bufferedWriter.close(); }
				catch (IOException e) { e.printStackTrace(); }
			}
			if (fileWriter != null) {
				try { fileWriter.close(); }
				catch (IOException e) { e.printStackTrace(); }
			}
		}
		
	}

}
