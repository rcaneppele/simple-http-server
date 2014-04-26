package br.com.rcaneppele.simplehttpserver.response;

public enum StatusCode {
	
	OK(200),
	ERROR(500);
	
	private final int code;

	private StatusCode(int code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return code +" " +super.toString();
	}
	
}
