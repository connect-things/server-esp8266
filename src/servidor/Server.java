package server.iot;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9000);
			while(true){
				Socket sock = server.accept();
				new Thread(){
					public void run() {
						try {
							InputStream is = sock.getInputStream();
							Scanner scan = new Scanner(is);
							while(scan.hasNext()){
								String line = scan.nextLine();
								System.out.println(line);
							}
							is.close();
							sock.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				}.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
