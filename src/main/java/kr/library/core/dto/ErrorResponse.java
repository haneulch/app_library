package kr.library.core.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {
	String code;
	String message;
	
	@JsonIgnore
	HttpStatus status;
}
