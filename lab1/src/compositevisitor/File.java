package compositevisitor;

public class File extends Entry {
    private String name;
    private int size;
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }
    /*protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }*/
	
    @Override
	public Entry add(Entry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(Visitor v) {
		v.visitFile(this);
	}
}
