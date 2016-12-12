package servidor;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEsp8266 {

	public static void main(String[] args) {
		
		try {
		
			//open socket server
			ServerSocket server = new ServerSocket(8080);
			while(true){
				//when Arduino connect
				Socket socket = server.accept();
				InputStream is = socket.getInputStream();
				Scanner scan = new Scanner(is);
				if(scan.hasNext()){
					//Line writted by arduino and received by server
					String line = scan.nextLine();
					System.out.println(line);
				}
				scan.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
