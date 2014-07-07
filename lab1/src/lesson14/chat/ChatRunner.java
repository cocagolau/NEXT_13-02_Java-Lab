package lesson14.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatRunner extends Thread {
	
	private boolean flag = false;
	private Socket socket;
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	
	public ChatRunner (Socket socket) throws IOException {
		this.socket = socket;
		br = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		bw = new BufferedWriter (new OutputStreamWriter (socket.getOutputStream()));
		
	}
	
	public void run() {
		try {
			while (!this.flag) {
				String msg = br.readLine();
				if (msg != null && !msg.equals(""))
					ChatServer.room.sendMsgAll(msg);
				else
					flag = true;
			}
			ChatServer.room.removeChatRunner(this);
			bw.close();
			br.close();
			socket.close();
		}
		catch (IOException ioe) { ioe.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public void sendMessage(String msg) throws IOException {
		bw.write (msg + "\n");
		bw.flush();
	}
	
	public String toString(){
		return socket.toString();
	}

}
