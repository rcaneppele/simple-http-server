package br.com.rcaneppele.simplehttpserver.request;

import java.io.InputStream;
import java.util.Scanner;

public class HttpRequestFactory {

	public HttpRequest create(InputStream is) {
		Scanner scanner = new Scanner(is);
		
		String startLine = scanner.nextLine();
		HttpMethod method = extractMethodFrom(startLine);
		String uri = extractUriFrom(startLine);
		String version = extractHttpVersionFrom(startLine);
		
		scanner.close();
		return new HttpRequest(method, uri, version);
	}

	private HttpMethod extractMethodFrom(String startLine) {
		String methodName = startLine.split(" ")[0];
		return HttpMethod.valueOf(methodName);
	}
	
	private String extractUriFrom(String startLine) {
		return startLine.split(" ")[1];
	}
	
	private String extractHttpVersionFrom(String startLine) {
		return startLine.split(" ")[2].replace("HTTP/", "");
	}

}
