package lesson14.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	
	public static ChatRoom room = new ChatRoom();
	
	public static void main (String[] args) throws IOException{
		ServerSocket sSocket = new ServerSocket(30000);
		System.out.println ("Chatting Server Start...");
		
		while (true) {
			Socket socket = sSocket.accept();
			System.out.println (socket + " in");
			ChatRunner cr = new ChatRunner(socket);
			ChatServer.room.addChatRunner(cr);
			cr.start();	
		}
	}
}
