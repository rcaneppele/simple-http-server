package br.com.rcaneppele.simplehttpserver.request;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HttpRequestFactoryTest {
	
	private HttpRequestFactory factory;
	
	@Before
	public void before() {
		this.factory = new HttpRequestFactory();
	}
	
	@Test
	public void it_should_create_an_http_request_with_get_method() {
		String startLine = "GET /test HTTP/1.1";
		InputStream is = createInputStreamFor(startLine);
		
		HttpRequest request = factory.create(is);
		
		Assert.assertEquals(HttpMethod.GET, request.getMethod());
	}
	
	@Test
	public void it_should_create_an_http_request_with_post_method() {
		String startLine = "POST /test HTTP/1.1";
		InputStream is = createInputStreamFor(startLine);
		
		HttpRequest request = factory.create(is);
		
		Assert.assertEquals(HttpMethod.POST, request.getMethod());
	}

	private ByteArrayInputStream createInputStreamFor(String content) {
		return new ByteArrayInputStream(content.getBytes());
	}
	
}
