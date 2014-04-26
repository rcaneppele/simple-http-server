package br.com.rcaneppele.simplehttpserver.request;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import br.com.rcaneppele.simplehttpserver.response.HttpResponse;
import br.com.rcaneppele.simplehttpserver.response.HttpResponseFactory;

public class HttpRequestHandler implements Runnable {

	private Socket client;
	
	public HttpRequestHandler(Socket client) {
		this.client = client;
	}

	public void run() {
		try {
			HttpRequest request = new HttpRequestFactory().create(client.getInputStream());
			System.out.println("Handling the request: " +request);
			
			sendResponse(new HttpResponseFactory().ok());
			
			client.close();
		} catch (Exception e) {
			sendResponse(new HttpResponseFactory().error());
		}
	}

	private void sendResponse(HttpResponse response) {
		try {
			PrintStream ps = new PrintStream(client.getOutputStream());
			
			ps.println(response.toString());
			
			ps.close();
		} catch (IOException e) {
			System.out.println("Could not send response to the client! " +e);
		}
	}

}
