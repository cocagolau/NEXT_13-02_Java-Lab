package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {

	static final String BEFORE_PATH = File.separator + "basicjava" + File.separator + "test" + File.separator + "A" + File.separator + "test.txt"; 
	static final String AFTER_PATH = File.separator + "basicjava" + File.separator + "test" + File.separator + "B";
	
	public static void main (String[] args) {
		
		CopyFile fCopy = new CopyFile();

		fCopy.copyFile(BEFORE_PATH, AFTER_PATH);
	}

	public void copyFile (String before, String after) {
		File beforeFile = new File (before);
//		System.out.println (beforeFile.getName());
		FileReader reader = null;
		BufferedReader bReader = null;
		FileWriter writer = null;
		BufferedWriter bWriter = null;
		
		try {
			writer = new FileWriter (after+File.separator+beforeFile.getName());
			bWriter = new BufferedWriter (writer);
			
			reader = new FileReader (BEFORE_PATH);
			bReader = new BufferedReader (reader);
			
			String line;
			while ( (line=bReader.readLine()) != null ) {
				bWriter.write(line);
				bWriter.newLine();
			}
			
			
			System.out.println ("Success");
		}
		catch (IOException ioe) { ioe.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
		finally {
			
			if (bReader != null) {
				try { bReader.close(); }
				catch (IOException ioe) {ioe.printStackTrace(); }
			}
			
			if (reader != null) {
				try { reader.close(); }
				catch (IOException ioe) {ioe.printStackTrace(); }
			}
			
			if (bWriter != null) {
				try { bWriter.close(); }
				catch (IOException ioe) {ioe.printStackTrace(); }
			}
			
			if (writer != null) {
				try { writer.close(); }
				catch (IOException ioe) {ioe.printStackTrace(); }
			}
		}
		
		
		
		
	}

}
