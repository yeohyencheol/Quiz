package chatMulti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;



public class ClientSender extends Thread {
	
	private Socket socket;
	
	public ClientSender(Socket socket) {
		this.socket = socket;
		
	}

	@Override
	public void run() {
		
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
			
			
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("[알림] 채팅방 이용하시려면 본인의 닉네임 입력 / 이용 후 나가시려면 exit 입력");
			
			while(true) {
				String msg = scan.nextLine();
				if(msg.equals("exit")) {
					System.out.println("종료합니다");
					break;
				}
				
				bw.write(msg);
				bw.newLine();
				bw.flush();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
