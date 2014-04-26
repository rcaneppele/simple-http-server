package br.com.rcaneppele.simplehttpserver.response;

public final class HttpResponse {

	private final StatusCode statusCode;
	
	public HttpResponse(StatusCode statusCode) {
		this.statusCode = statusCode;
	}
	
	@Override
	public String toString() {
		return getStartLine();
	}

	private String getStartLine() {
		return "HTTP/1.1 " +statusCode;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

}
