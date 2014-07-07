package lesson14.newchat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom {

	private List<ChatRunner> runnerLists = new ArrayList<ChatRunner>();
	
	public synchronized void addChatRunner(ChatRunner cr) {
		runnerLists.add(cr);
	}

	public synchronized void sendMsgAll(String msg) throws IOException{
		for (ChatRunner cr : runnerLists) {
			cr.sendMessage(msg);
		}
	}

	public synchronized void removeChatRunner(ChatRunner cr) {
		if (runnerLists.contains(cr))
			runnerLists.remove(cr);
		
	}
	
	

}
