package br.com.rcaneppele.simplehttpserver.request;

import java.io.InputStream;
import java.util.Scanner;

public class HttpRequestFactory {

	public HttpRequest create(InputStream is) {
		Scanner scanner = new Scanner(is);
		validatePresenceOfStartLine(scanner);
		
		String startLine = scanner.nextLine();
		validateStartLine(startLine);
		
		HttpMethod method = extractMethodFrom(startLine);
		String uri = extractUriFrom(startLine);
		String version = extractHttpVersionFrom(startLine);
		
		return new HttpRequest(method, uri, version);
	}
	
	private void validatePresenceOfStartLine(Scanner scanner) {
		if (!scanner.hasNextLine()) {
			throw new IllegalArgumentException("The Http Request received has no Start Line!");
		}
	}
	
	private void validateStartLine(String startLine) {
		if (startLine.isEmpty() || startLine.split(" ").length != 3) {
			throw new IllegalArgumentException("Invalid Start Line!");
		}
	}

	private HttpMethod extractMethodFrom(String startLine) {
		String methodName = startLine.split(" ")[0];
		return HttpMethod.valueOf(methodName);
	}
	
	private String extractUriFrom(String startLine) {
		return startLine.split(" ")[1];
	}
	
	private String extractHttpVersionFrom(String startLine) {
		return startLine.split(" ")[2];
	}
	
}
