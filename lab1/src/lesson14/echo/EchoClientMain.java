package lesson14.echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoClientMain {
	
	public static void main (String[] args) throws IOException {
		Socket socket = new Socket ("127.0.0.1", 50000);
		BufferedWriter bw;
		BufferedReader br;
		
		bw = new BufferedWriter (new OutputStreamWriter (socket.getOutputStream()));
		br = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		
		bw.write ("¾È³ç ÇÏ¼¼¿ä" + "\n");
		bw.flush();
		System.out.println (br.readLine());
		System.out.println (br.readLine());
		System.out.println (br.readLine());
		
		br.close();
		bw.close();
		socket.close();
		
	}

}
