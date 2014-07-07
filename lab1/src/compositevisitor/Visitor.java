package compositevisitor;

public abstract class Visitor {
	public abstract void visitFile (File file);
	public abstract void visitDirectory(Directory directory);
}
