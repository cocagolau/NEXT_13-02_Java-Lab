package lesson12;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInMain {
	
	public static void main(String[] args) throws IOException {
		System.out.println ("press Enter Key");
		InputStreamReader reader = new InputStreamReader(System.in);
		int i;
		while ( (i=reader.read()) != '³¡') {
			System.out.println ((char)i + ":" + i);
		}
		
		/*int i = System.in.read();
		System.out.println (i);
		
		i = System.in.read();
		System.out.println (i);*/
		
		
	}

}
