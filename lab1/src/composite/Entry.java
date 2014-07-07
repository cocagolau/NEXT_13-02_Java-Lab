package composite;

public abstract class Entry {
    public abstract String getName();                               // 이름을 얻는다.
    public abstract int getSize();                                  // 사이즈를 얻는다.
    public abstract Entry add(Entry entry); 
    public void printList() {                                       // 일람을 표시한다.
        printList("");
    }
    protected abstract void printList(String prefix);               // prefix를 앞에 붙여서 일람을 표시한다.
    public String toString() {                                      // 문자열 표현
        return getName() + " (" + getSize() + ")";
    }
}
