import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class DynamicDataMain {
	
	public static void main (String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException{
		System.out.println ("downloading...");
		URL url = new URL ("http://127.0.0.1:9090/DynamicData.class");
		FileOutputStream fos = new FileOutputStream (".//bin//DynamicData.class");
		InputStream is = url.openStream();
		
		int i;
		while ( (i=is.read()) != -1) {
			fos.write (i);
			System.out.print ("|");
		}
		System.out.println();
		
		is.close();
		fos.close();
		
		Class c = Class.forName("DynamicData");
		Object obj = c.newInstance();
		System.out.println (obj);
	}

}
