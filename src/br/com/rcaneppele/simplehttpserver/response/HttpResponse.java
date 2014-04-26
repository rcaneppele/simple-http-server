package br.com.rcaneppele.simplehttpserver.response;

public final class HttpResponse {

	private final StatusCode statusCode;
	
	public HttpResponse(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

}
