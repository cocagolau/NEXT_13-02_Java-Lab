package compositevisitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private String name;                    // ���丮�� �̸�
    private ArrayList<Entry> directory = new ArrayList<Entry>();      // ���丮 ��Ʈ���� ����
    public Directory(String name) {         // ������
        this.name = name;
    }
    public String getName() {               // �̸��� ��´�.
        return name;
    }
    public int getSize() {                  // ����� ��´�.
        int size = 0;
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }
   
    public Entry add(Entry entry) {         // ��Ʈ���� �߰�
        directory.add(entry);
        return this;
    }
	public Iterator<Entry> iterator() {
		Iterator<Entry> ir = directory.iterator(); 
		return ir;
	}

	@Override
	public void accept(Visitor v) {
		v.visitDirectory(this);
	}
  
    
    /*protected void printList(String prefix) {       // ��Ʈ���� �϶�
        System.out.println(prefix + "/" + this);
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.printList(prefix + "/" + name);
        }
    }*/
}
