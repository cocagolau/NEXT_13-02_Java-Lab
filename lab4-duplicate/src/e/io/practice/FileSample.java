package e.io.practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSample {
	
	public static void main (String[] args) {
		FileSample sample = new FileSample();
		
		String pathName = File.separator + "basicjava" + File.separator + "text";
		String fileName = "test.txt";
//		sample.checkPath(pathName);
//		sample.checkFile(pathName, fileName);
		sample.checkList(pathName);
		
	}
	
	public void checkPath(String pathName) {
		File file = new File(pathName);
		System.out.println (pathName = " is : " + file.mkdirs());
	}
	
	public void checkFile(String pathName, String fileName) {
		File file = new File(pathName, fileName);
		try {
			System.out.println ("create result = " + file.createNewFile());
			
			System.out.println ("Absolute path = " + file.getAbsolutePath());
			System.out.println ("Absolute file = " + file.getAbsoluteFile());
			System.out.println ("Canonical path = " + file.getCanonicalPath());
			System.out.println ("Canonical file = " + file.getCanonicalFile());
			
			System.out.println ("Name = " + file.getName());
			System.out.println ("Path = " + file.getPath());
			
			System.out.println ("parent = " + file.getParent());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void checkList(String pathName) {
		File file;
		
		try {
			file = new File(pathName);
//			File[] mainFileList = file.listFiles();
//			File[] mainFileList = file.listFiles(new JPGFilenameFilter());
			File[] mainFileList = file.listFiles(new JPGFileFilter());
			
			for (File f : mainFileList)
				System.out.println (f.getName());
		}
		catch(Exception e){ e.printStackTrace(); }
	}

	
	
	
	
	
	
	
	
}





