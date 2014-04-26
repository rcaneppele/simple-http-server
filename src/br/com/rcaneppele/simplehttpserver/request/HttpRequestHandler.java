package br.com.rcaneppele.simplehttpserver.request;

import java.net.Socket;

public class HttpRequestHandler implements Runnable {

	private Socket client;
	
	public HttpRequestHandler(Socket client) {
		this.client = client;
	}

	public void run() {
		try {
			HttpRequest request = new HttpRequestFactory().create(client.getInputStream());
			System.out.println("Handling the request: " +request);
			
			client.close();
		} catch (Exception e) {
			
		}
	}

}
