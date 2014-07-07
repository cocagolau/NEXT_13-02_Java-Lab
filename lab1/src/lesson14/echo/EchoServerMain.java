package lesson14.echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerMain {
	
	public static void main (String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(50000);
		System.out.println (50000 + "Port echo server running...");
		
		while (true) {
			Socket socket = ss.accept();
			BufferedReader br;
			BufferedWriter bw;
			
			br = new BufferedReader (new InputStreamReader (socket.getInputStream()));
			bw = new BufferedWriter (new OutputStreamWriter (socket.getOutputStream()));
			
			String temp = br.readLine();
			bw.write (temp + "1 \n");
			bw.flush();
			bw.write (temp + "2 \n");
			bw.flush();
			bw.write (temp + "3 \n");
			bw.flush();
			
			bw.close();
			br.close();
			socket.close();
			
		}
		
	}

}
