package lesson14.chat;

import java.io.*;
public class ChatClientMain{
	
	public static void main(String[] args) throws IOException{
		//if(args.length == 3){
			ChatClient client;
			client = new ChatClient("µ¿", "127.0.0.1", 30000);
			client.setSize(300, 200);
			client.setTitle("µ¿");
			client.setVisible(true);
		//}
	} 
} 