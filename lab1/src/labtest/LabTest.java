package labtest;
import junit.framework.TestCase;
import java.util.Date;
import labtest.StaticEx;

public class LabTest extends TestCase{
	
	public void testRandom() {
		int score = (int)(Math.random()*10) + 1;
		
		switch (score*100) {
		case 100:
			System.out.println (score + " 100");
			break;
		case 200:
			System.out.println (score + " 200");
			break;
		case 300:
			System.out.println (score + " 300");
			break;
		case 400:
			System.out.println (score + " 400");
			break;
		case 500:
			System.out.println (score + " 500");
			break;
		default :
			System.out.println ("꽝");
		}
	}
	
	
	public static Date then;
	// static 블럭, static변수 초기화시
	static {
		long now = System.currentTimeMillis();
		then = new Date(now);
		
	}
	
	// 인스턴스블럭 ,  = 객체 생성시
	{
		
	}
	
	public void testStatic () {
		String str = StaticEx.str1;
		String str2 = StaticEx.getStr1();
		
		
	}
	
	public void testDate() {
		Date now = new Date();
		
		System.out.println (now);
		
		Date date = new Date(113,6,10);
		System.out.println (date);
	}
	
	public void testMotorCycle () {
		MotorCycle moto = new MotorCycle();
		moto.setData(1, 200);
		
		moto.drive();
		System.out.println (moto);
		
		MotorCycle mo = moto;
		moto.setData(2, 300);
		moto.drive();
	}
	
	public void testString() {
//		String str1 = "aaa";
//		String str2 = "aaa";
		
		String a1 = new String("a");
		String a2 = new String("a");
		
		System.out.println (a1.equals(a2));
		System.out.println (a1 == a2);
	}
	
	public void testStringToInt () {
		String numbers[] = {"1","2","3","4","5"};
		String result1 = "";
		int result2 = 0;
		
		for (String str : numbers) {
			result1 += str;
			result2 += Integer.parseInt(str);
		}
		System.out.println (result1);
		System.out.println (result2);
	}
	
	
	public void testStaticString() {
		String abc = "abc";
	}
	
	public void testDynamicString(){
		String abc = new String("abc");
	}
	
	
}
