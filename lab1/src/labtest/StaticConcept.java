package labtest;

public class StaticConcept {
	
	public static int s;
	public int a;
	public int b;
	
	public static void main (String[] args) {
		StaticConcept s1 = new StaticConcept();
		StaticConcept s2 = new StaticConcept();
		StaticConcept s3 = new StaticConcept();
		
		s1.s = 0; s1.a = 1; s1.b = 2;
		s2.s = 10; s2.a = 11; s2.b = 12;
		s3.s = 100; s3.a = 101; s3.b = 102;
		
		System.out.println (s1.s + " " + s1.a + " " + s1.b);
		System.out.println (s2.s + " " + s2.a + " " + s2.b);
		System.out.println (s3.s + " " + s3.a + " " + s3.b);
	}

}
