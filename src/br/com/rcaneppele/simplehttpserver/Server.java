package br.com.rcaneppele.simplehttpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static final int PORT = 5050;

	public static void main(String[] args) throws IOException {
		try (ServerSocket server = new ServerSocket(PORT)) {
			while (true) {
				Socket client = server.accept();
				
				System.out.println("new http request received: " +client);
				
				client.close();
			}
		}
	}

}
