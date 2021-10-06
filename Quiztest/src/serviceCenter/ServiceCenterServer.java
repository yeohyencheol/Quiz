package serviceCenter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServiceCenterServer {
	public static void main(String[] args) {
		
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		System.out.println("***여기는 퀴즈 안내센터입니다***");
		
		try {
			ServerSocket serverSocket = new ServerSocket(7777);
			
			System.out.println("유저로부터 문의받는 중...");
			socket = serverSocket.accept();
			System.out.println("접속 성공: "+socket.getPort());
			

			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
			
			System.out.println("상담 준비 완료");
			
			while(true) {
				String msg = br.readLine();
				System.out.println("문의 내용 : "+msg);
				
				Scanner scan = new Scanner(System.in);
				
				bw.write(scan.nextLine());
				bw.newLine();
				bw.flush();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}
}
