package br.com.rcaneppele.simplehttpserver.request;

public final class HttpRequest {

	private final HttpMethod method;

	public HttpRequest(HttpMethod method) {
		this.method = method;
	}

	public HttpMethod getMethod() {
		return method;
	}

}
