

public class Adder {
	int add (int i, int j) {
		return i+j;
	}
	
	public static void main (String[] args) {
		Adder adder = new Adder();
		int result = adder.add(5, 2);
		System.out.println (result);
	}

}
