package compositevisitor;

import java.util.Iterator;

public class ListVisitor extends Visitor{
	
	private String currentDir = "";
	public void visitFile (File file) {
		System.out.println(currentDir + "/" + file.getName());
	}
	
	public void visitDirectory (Directory directory) {
		System.out.println(currentDir + "/" + directory);
		String saveDir = currentDir;
		currentDir = currentDir + "/" + directory.getName();
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.accept(this);
        }
        System.out.println ("c: " + currentDir);
        System.out.println ("s: " + saveDir);
        currentDir =  saveDir;
        
        
	}

}
