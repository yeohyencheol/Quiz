package chatMulti;

import java.io.IOException;

public class Chatmain {
	public static void main(String[] args) {
	try {	
		UserChatRoom server = new UserChatRoom(7777);
		
		server.runServer();
	} catch (IOException e) {
		e.printStackTrace();
		
	}
 }	
}
