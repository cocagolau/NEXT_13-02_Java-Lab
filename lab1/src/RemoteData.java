
public class RemoteData {
	
	public String name = "no name";
	public String addr = "no addr";
	public RemoteData(){}
	public RemoteData(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}
	
	public void sayHello() {
		System.out.println(this.name + "hi");
	}
	public void sayHello(String name) {
		this.name = name;
		System.out.println(this.name + "hi");
	}
	public void goodBye() {
		System.out.println(this.name + "bye~!");
	}
	public void goodBye(String name) {
		this.name = name;
		System.out.println(this.name + "bye~!");
	}
	
	public String toString () {
		return super.toString() + ":" + name+":" +addr;
	}

}
