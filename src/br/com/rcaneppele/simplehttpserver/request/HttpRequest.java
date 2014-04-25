package br.com.rcaneppele.simplehttpserver.request;

public final class HttpRequest {

	private final HttpMethod method;
	private final String uri;
	private final String httpVersion;

	public HttpRequest(HttpMethod method, String uri, String httpVersion) {
		this.method = method;
		this.uri = uri;
		this.httpVersion = httpVersion;
	}
	
	public String getStartLine() {
		return method +" " +uri +" " +httpVersion;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public String getUri() {
		return uri;
	}

	public String getHttpVersion() {
		return httpVersion;
	}

}
