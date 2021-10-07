package chatMulti;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {
	public static void main(String[] args) {
		
		try(Socket socket = new Socket("192.168.75.232", 7777)) {
			
			System.out.println("-------유저 대화방 입니다-------");
			
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			ClientSender clientSender = new ClientSender(socket);
			clientReceiver.start();
			clientSender.start();
			clientSender.join();
			System.out.println("대화방이 종료됩니다.");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
