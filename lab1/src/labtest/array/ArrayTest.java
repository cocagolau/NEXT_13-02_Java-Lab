package labtest.array;

import junit.framework.TestCase;

public class ArrayTest extends TestCase{
	
	public void testObjectArray() {
		Dog[] dogs = new Dog[3];
		
		initialize(dogs);
		
		assertEquals ("test", dogs[0].getName());
		assertEquals ("�۸���", dogs[1].getName());
		assertEquals ("�ʶ���", dogs[2].getName());
	}
	
	public void initialize(Dog[] dogs) {
		
		dogs[0] = new Dog("test");
		dogs[1] = new Dog("�۸���");
		dogs[2] = new Dog("�ʶ���");
		
	}

}
