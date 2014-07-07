package lesson14.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom {

	private List<ChatRunner> chatRunnerList = new ArrayList<ChatRunner>();

	public void addChatRunner(ChatRunner cr) {
		chatRunnerList.add(cr);
	}
	
	
	public void removeChatRunner(ChatRunner chatRunner) {
		if (chatRunnerList.contains(chatRunner))
			chatRunnerList.remove(chatRunner);	
	}


	public void sendMsgAll(String msg) throws IOException{
		for (ChatRunner cr : chatRunnerList)
			cr.sendMessage(msg);
	}

}
