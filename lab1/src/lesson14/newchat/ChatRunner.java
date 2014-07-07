package lesson14.newchat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatRunner extends Thread {
	
	private boolean flag = false;
	private Socket socket = null;
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	
	public ChatRunner (Socket socket) {
		this.socket = socket;
		
		try {
			br = new BufferedReader (new InputStreamReader (socket.getInputStream()));
			bw = new BufferedWriter (new OutputStreamWriter (socket.getOutputStream()));
		} catch ( IOException ioe) { ioe.printStackTrace(); }
	}
	
	
	public void run() {
		try {
			while(!flag) {
				String msg = br.readLine();
				if (msg!=null && !msg.equals(""))
					ChatServer.room2.sendMsgAll(msg);
				else
					flag = true;
			}
			ChatServer.room2.removeChatRunner(this);
			bw.close();
			br.close();
			socket.close();
		} catch (IOException ioe) { ioe.printStackTrace(); }
	}
	
	public void sendMessage (String msg) throws IOException {
		bw.write(msg + "\n");
		bw.flush();
	}
	
	public String toString() {
		return socket.toString();
	}


}
