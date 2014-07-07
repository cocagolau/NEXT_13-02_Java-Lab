package composite;

public abstract class Entry {
    public abstract String getName();                               // �̸��� ��´�.
    public abstract int getSize();                                  // ����� ��´�.
    public abstract Entry add(Entry entry); 
    public void printList() {                                       // �϶��� ǥ���Ѵ�.
        printList("");
    }
    protected abstract void printList(String prefix);               // prefix�� �տ� �ٿ��� �϶��� ǥ���Ѵ�.
    public String toString() {                                      // ���ڿ� ǥ��
        return getName() + " (" + getSize() + ")";
    }
}
