package br.com.rcaneppele.simplehttpserver.response;

public class HttpResponseFactory {

	public HttpResponse ok() {
		return new HttpResponse(StatusCode.OK);
	}

	public HttpResponse error() {
		return new HttpResponse(StatusCode.ERROR);
	}

}
