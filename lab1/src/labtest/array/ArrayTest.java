package labtest.array;

import junit.framework.TestCase;

public class ArrayTest extends TestCase{
	
	public void testObjectArray() {
		Dog[] dogs = new Dog[3];
		
		initialize(dogs);
		
		assertEquals ("test", dogs[0].getName());
		assertEquals ("∏€∏€¿Ã", dogs[1].getName());
		assertEquals ("∂ ∂ ¿Ã", dogs[2].getName());
	}
	
	public void initialize(Dog[] dogs) {
		
		dogs[0] = new Dog("test");
		dogs[1] = new Dog("∏€∏€¿Ã");
		dogs[2] = new Dog("∂ ∂ ¿Ã");
		
	}

}
