package kr.library.core.exception;

import org.springframework.http.HttpStatus;

public class ExpiredTokenException extends RuntimeException {
	private HttpStatus status;
	
	public ExpiredTokenException(String message) {
		super(message);
		this.status = HttpStatus.UNAUTHORIZED;
	}
	
	public ExpiredTokenException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
}