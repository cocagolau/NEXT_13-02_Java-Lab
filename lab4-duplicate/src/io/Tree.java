package io;

import java.io.File;
import java.io.IOException;

public class Tree {

	public static void main (String[] args) throws IOException{
		
		Tree tree = new Tree();
		String path = "C:\\basicjava";
		
		tree.makeTree (0, new File(path));
	}

	private int makeTree(int depth, File parentFile) throws IOException {
		
		File[] dirs = parentFile.listFiles(new TreeDirFilter());
		File[] files = parentFile.listFiles(new TreeFileFilter());
		
		for (File dir : dirs) {
			printContents(depth, dir);
			depth = makeTree(++depth, dir);
		}
		
		for (File file : files) {
			printContents(depth, file);
		}
		System.out.println();
		return --depth;
		
	}

	private void printContents(int depth, File file) {
		if (file.isDirectory()) {
			for (int i=0; i<depth; i++)
				System.out.print("   ");
			System.out.println ("["+file+"]");
		}
		else {
			for (int i=0; i<depth; i++)
				System.out.print("   ");
			
			if (depth == 0)
				System.out.println (file);
			else
				System.out.println ("¦¦"+file);
		}
	}

}
