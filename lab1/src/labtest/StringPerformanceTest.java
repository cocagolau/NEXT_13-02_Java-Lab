package labtest;
import junit.framework.TestCase;

public class StringPerformanceTest extends TestCase{
	public void testString () {
		final int count = 100000;
		
		String s1 = "Hello";
		String s2 = "World";
		
		long start = System.currentTimeMillis();
		
		for (int i=0; i<count; i++) {
			//s1 = s1 + s2;
			s1 = s1.concat(s2);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println ("Time is " + (end-start));
	}
	
	public void testStringBuffer () {
		final int count = 100000;
		
		String s1 = "Hello";
		String s2 = "World";
		
		long start = System.currentTimeMillis();
		
		
		StringBuffer sb1 = new StringBuffer (s1);
		StringBuffer sb2 = new StringBuffer (s2);
		
		for (int i=0; i<count; i++) {
			sb1 = sb1.append(sb2);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println ("Time is " + (end-start));
	}
	
	public void testStringBuilder () {
		final int count = 100000;
		
		String s1 = "Hello";
		String s2 = "World";
		
		long start = System.currentTimeMillis();
		
		
		StringBuilder sb1 = new StringBuilder (s1);
		StringBuilder sb2 = new StringBuilder (s2);
		
		for (int i=0; i<count; i++) {
			sb1 = sb1.append(sb2);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println ("Time is " + (end-start));
	}
}
