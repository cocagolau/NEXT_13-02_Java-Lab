import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class DynamicLoader {
	
	public static Class loadClass(String url, String className) throws MalformedURLException, ClassNotFoundException {
		URL[] urls = {new URL(url)};
		URLClassLoader loader = new URLClassLoader (urls);
		
		Class c = loader.loadClass(className);
		
		return c;
	}

}
