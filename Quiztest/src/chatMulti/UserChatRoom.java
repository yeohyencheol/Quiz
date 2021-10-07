package chatMulti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class UserChatRoom {

	private ServerSocket serverSocket;
	private List<UserChatRoom.User> userList;
	
	public UserChatRoom(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		userList = new ArrayList<UserChatRoom.User>();
	}
	
	
	//서버 기능
	public void runServer() throws IOException {
		while(true) {
			System.out.println("접속 대기중 ....");
			Socket socket = serverSocket.accept();
			System.out.println("접속 : "+socket.getInetAddress()+"-"+socket.getPort());
			
			//user객체 생성
			User user = new User(socket);
			
			userList.add(user);
			
			user.start();
			
			System.out.println("현재 "+userList.size()+"명이 채팅방 이용중");
		}
		
	}
	
	class User extends Thread{
		private String name;
		private Socket socket;
		private BufferedWriter bw;
		private BufferedReader br;
		
		public User(Socket socket) throws IOException {
			this.socket = socket;
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
		
		@Override
		public void run() {
			
			BufferedReader br = null;
			
			try {
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
			//접속시 초기셋팅과 초기 알림
			bw.write("***채팅 예절 엄수! 바르고 고운 말을 씁시다!*** \r\n");
			bw.flush();
			
			this.name = br.readLine();
			for(User user : userList) {
				if(this!=user) {
					user.bw.write("*"+name+"님이 접속하였습니다.");
					user.bw.newLine();
					user.bw.flush();
				}
			}
			
			//사용자가 입력했을 때 메시지를 보내기
			String msg = null;
			while(true) {
				//연결되어 있는 사람의 메시지를 읽고
				msg = br.readLine();
				if(msg == null) {
					throw new Exception();
				}
				//모든 유저에게 전달
				for(User user : userList) {
					if(this != user) {           
						user.bw.write("["+name+"] : "+msg);
						user.bw.newLine();
						user.bw.flush();
					}
				}
			}
		}catch (Exception e) {
			userList.remove(this);
			try {
				for(User user : userList) {
					user.bw.write("*"+name+"님이 방을 나갔습니다.");
					user.bw.newLine();
					user.bw.flush();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		}	
	}
}
