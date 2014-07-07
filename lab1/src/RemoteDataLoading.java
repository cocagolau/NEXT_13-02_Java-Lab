import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;


public class RemoteDataLoading {
	
	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		String url = "http://127.0.0.1:9090/";
		Class c = DynamicLoader.loadClass(url, "RemoteData");
		Object obj = c.newInstance();
		
		Class[] parameterTypes = {String.class, String.class};
		Constructor cons = c.getConstructor(parameterTypes);
		
		Object[] initargs = new Object[]{"seo", "seoul"};
		Object objc = cons.newInstance(initargs);
		
//		System.out.println (objc);
		
//		Method met = c.getMethod("sayHello");
//		Object obj1 = met.invoke(met);
//		System.out.println (obj1);
		
		Method m = c.getMethod("sayHello", null);
		m.invoke(objc, null);
//		System.out.println (objc);
		
		Class[] parameterTypes1 = {String.class};
		Method m1 = c.getMethod("sayHello", parameterTypes1);
		m1.invoke(objc, "Lim");
	}

}
