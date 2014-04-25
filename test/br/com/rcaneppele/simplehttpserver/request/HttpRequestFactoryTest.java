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
	
	@Test
	public void it_should_create_an_http_request_with_an_especific_uri() {
		String startLine = "GET /my/resource HTTP/1.1";
		InputStream is = createInputStreamFor(startLine);
		
		HttpRequest request = factory.create(is);
		
		Assert.assertEquals("/my/resource", request.getUri());
	}
	
	@Test
	public void it_should_create_an_http_request_with_an_especific_http_version() {
		String startLine = "GET /test HTTP/1.1";
		InputStream is = createInputStreamFor(startLine);
		
		HttpRequest request = factory.create(is);
		
		Assert.assertEquals("HTTP/1.1", request.getHttpVersion());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void it_should_not_create_an_http_request_without_a_start_line() {
		String startLine = "";
		InputStream is = createInputStreamFor(startLine);
		
		factory.create(is);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void it_should_not_create_an_http_request_with_an_invalid_http_method() {
		String startLine = "FAIL /test HTTP/1.1";
		InputStream is = createInputStreamFor(startLine);
		
		factory.create(is);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void it_should_not_create_an_http_request_without_http_method() {
		String startLine = "/test HTTP/1.1";
		InputStream is = createInputStreamFor(startLine);
		
		factory.create(is);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void it_should_not_create_an_http_request_without_uri() {
		String startLine = "GET HTTP/1.1";
		InputStream is = createInputStreamFor(startLine);
		
		factory.create(is);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void it_should_not_create_an_http_request_without_http_version() {
		String startLine = "GET /test";
		InputStream is = createInputStreamFor(startLine);
		
		factory.create(is);
	}

	private ByteArrayInputStream createInputStreamFor(String content) {
		return new ByteArrayInputStream(content.getBytes());
	}
	
}
