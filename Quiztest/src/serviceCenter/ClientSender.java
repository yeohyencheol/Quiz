package serviceCenter;

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
			System.out.println("문의사항을 입력해주세요");
			
			while(true) {
				String msg = scan.nextLine();
				if(msg.equals("q")) {
					System.out.println("종료합니다");
					break;
				}
				if(msg.equals("1")) {
					System.out.println("A. 10문제이며 1문제당 10점 총 100점 만점입니다.");
				}
				if(msg.equals("2")) {
					System.out.println("20점미만 - 브론즈 \r\n"
							+ "40점미만 - 실버 \r\n"
							+ "60점미만 - 골드 \r\n"
							+ "80점미만 - 플레 \r\n"
							+ "100점   - 다이아");
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
