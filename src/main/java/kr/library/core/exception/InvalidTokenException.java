package kr.library.core.exception;

import org.springframework.http.HttpStatus;

public class InvalidTokenException extends RuntimeException {
	private HttpStatus status;
	
	public InvalidTokenException(String message) {
		super(message);
		this.status = HttpStatus.UNAUTHORIZED;
	}
	
	public InvalidTokenException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
}