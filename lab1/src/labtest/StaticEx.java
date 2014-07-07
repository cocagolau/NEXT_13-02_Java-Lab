package labtest;

public class StaticEx {
	
	public static String str1 = "aaa";
	public String str2 = "bbb";

	public static String getStr1() {
		return StaticEx.str1;
	}
	
	public String getStr2 () {
		return this.str2;
	}
}
