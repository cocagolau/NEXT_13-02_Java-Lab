package lesson10;

import java.net.MalformedURLException;
import java.net.URL;

public class ShiftCatch {
	
	public URL makeUrl (String urlstr) throws MalformedURLException {
		return new URL(urlstr);
	}
	
	public static void main (String args[]) {
		ShiftCatch p = new ShiftCatch();
		
		try {
			URL url = p.makeUrl ("htttp:www.naver.com");
			System.out.println ("Success");
		}catch(MalformedURLException e) {
			e.printStackTrace();
			
		}finally {
			System.out.println ("finally: here");
			
		}
	}

}
