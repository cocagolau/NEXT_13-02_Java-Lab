package lesson14.newchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lesson14.newchat.ChatRunner;
import lesson14.newchat.ChatServer;


public class ChatServer {
	
	public static ChatRoom room2 = new ChatRoom();
	public static void main (String[] args) throws IOException {
		
		ServerSocket sSocket = new ServerSocket(30000);
		System.out.println ("running...");
		
		while (true) {
			Socket socket = sSocket.accept();
			System.out.println (socket + " start");
			
			ChatRunner cr1 = new ChatRunner(socket);
			ChatServer.room2.addChatRunner(cr1);
			cr1.start();
		}
		
//		while (true) {
//			Socket socket = sSocket.accept();
//			System.out.println (socket + " in");
//			ChatRunner cr = new ChatRunner(socket);
//			ChatServer.room.addChatRunner(cr);
//			cr.start();	
//		}
		
		
	}

}
