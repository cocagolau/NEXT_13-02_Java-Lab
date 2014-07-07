package javalab_test;

import junit.framework.TestCase;
import lab.abs.AbstractClass1;
import lab.abs.AbstractClass2;
import lab.abs.AbstractClass3;

public class AbstractClassTest extends TestCase{
	public void testAbstractClass () {
		
//		AbstractClass ab = new AbstractClass();
		AbstractClass1 ab1 = new AbstractClass1();
		AbstractClass2 ab2 = new AbstractClass2();
		AbstractClass3 ab3 = new AbstractClass3();
		
		assertEquals (9*4, ab1.move(9, 4));
		assertEquals ("stop", ab1.stop());
		
		assertEquals (9+4, ab2.move(9, 4));
		assertEquals ("stop", ab2.stop());
		
		assertEquals (9-4, ab3.move(9, 4));
		assertEquals ("stop", ab3.stop());
		
		
	}

}
