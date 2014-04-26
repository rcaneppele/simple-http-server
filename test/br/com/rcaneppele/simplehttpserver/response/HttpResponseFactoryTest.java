package br.com.rcaneppele.simplehttpserver.response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HttpResponseFactoryTest {
	
	private HttpResponseFactory factory;
	
	@Before
	public void before() {
		this.factory = new HttpResponseFactory();
	}
	
	@Test
	public void it_should_create_an_http_response_whith_status_code_200() {
		HttpResponse response = factory.ok();
		
		Assert.assertEquals(StatusCode.OK, response.getStatusCode());
	}
	
	@Test
	public void it_should_create_an_http_response_whith_status_code_500() {
		HttpResponse response = factory.error();
		
		Assert.assertEquals(StatusCode.ERROR, response.getStatusCode());
	}

}
