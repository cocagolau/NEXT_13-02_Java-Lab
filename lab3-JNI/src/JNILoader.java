
public class JNILoader {
	static{
		System.loadLibrary("MyDll");
	}
	public native void greet();
}
