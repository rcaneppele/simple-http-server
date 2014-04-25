package br.com.rcaneppele.simplehttpserver;

import java.net.ServerSocket;
import java.net.Socket;

import br.com.rcaneppele.simplehttpserver.request.HttpRequestHandler;

public class Server {
	
	private final int SERVER_PORT = 5050;

	public static void main(String[] args) throws Exception {
		new Server().start();
	}
	
	private void start() throws Exception {
		try(ServerSocket server = new ServerSocket(SERVER_PORT)) {
			while (true) {
				Socket client = server.accept();
				System.out.println("new http request received from: " +client.getInetAddress().getHostAddress());
				
				HttpRequestHandler handler = new HttpRequestHandler(client);
				new Thread(handler).start();
			}
		}
	}

}
