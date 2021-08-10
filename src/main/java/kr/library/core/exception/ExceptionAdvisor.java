package kr.library.core.exception;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.library.core.dto.ErrorResponse;
import kr.library.core.util.JsonResponseUtils;

@ControllerAdvice
@Controller
public class ExceptionAdvisor {
	
	@ExceptionHandler(ExpiredTokenException.class)
	public ResponseEntity<Map<String, Object>> expiredToken(ExpiredTokenException e) {
		ErrorResponse response = ErrorResponse.builder()
									.code(e.getStatus().value())
									.status(e.getStatus())
									.message(e.getMessage())
									.build();
		return JsonResponseUtils.error(response);
	}
	
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<Map<String, Object>> expiredToken(InvalidTokenException e) {
		ErrorResponse response = ErrorResponse.builder()
				.code(e.getStatus().value())
				.status(e.getStatus())
				.message(e.getMessage())
				.build();
		return JsonResponseUtils.error(response);
	}
}