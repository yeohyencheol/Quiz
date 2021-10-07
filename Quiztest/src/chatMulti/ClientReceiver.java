package chatMulti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;



public class ClientReceiver extends Thread {
	
	private Socket socket;
	
	public ClientReceiver(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
			while(true) {
				System.out.println(br.readLine());
			
			}	
		} catch (IOException e) {
			
		}
	}
	
}
