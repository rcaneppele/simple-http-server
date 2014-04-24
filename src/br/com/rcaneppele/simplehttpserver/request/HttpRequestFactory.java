package br.com.rcaneppele.simplehttpserver.request;

import java.io.InputStream;
import java.util.Scanner;

public class HttpRequestFactory {

	public HttpRequest create(InputStream is) {
		Scanner scanner = new Scanner(is);
		
		String startLine = scanner.nextLine();
		HttpMethod method = extractMethodFrom(startLine);
		
		scanner.close();
		return new HttpRequest(method);
	}

	private HttpMethod extractMethodFrom(String startLine) {
		String methodName = startLine.split(" ")[0];
		return HttpMethod.valueOf(methodName);
	}

}
