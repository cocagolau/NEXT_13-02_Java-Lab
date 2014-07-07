package compositevisitor;

public abstract class Entry extends Acceptor {
    public abstract String getName();                               // �̸��� ��´�.
    public abstract int getSize();                                  // ����� ��´�.
    public abstract Entry add(Entry entry); 
//    public void printList() {                                       // �϶��� ǥ���Ѵ�.
//        printList("");
//    }
//    protected abstract void printList(String prefix);               // prefix�� �տ� �ٿ��� �϶��� ǥ���Ѵ�.
    public String toString() {                                      // ���ڿ� ǥ��
        return getName() + " (" + getSize() + ")";
    }
    
}
