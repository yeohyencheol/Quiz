package serviceCenter;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {
	public static void main(String[] args) {
		
		try(Socket socket = new Socket("192.168.75.232", 7777)) {
			
			System.out.println("여기는 퀴즈 안내센터입니다. 더 이상의 문의가 없으시면 'q'를 입력해주세요");
			
			System.out.println("FAQ - 원하시는 문의의 번호를 입력하세요");
			System.out.println("1.총 몇문제 인가요?");
			System.out.println("2.티어는 어떻게 구분되나요?");
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			ClientSender clientSender = new ClientSender(socket);
			clientReceiver.start();
			clientSender.start();
			clientSender.join();
			System.out.println("프로그램이 종료됩니다.");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
