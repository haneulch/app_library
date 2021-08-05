package kr.stam.app.dto;

import org.springframework.lang.Nullable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlaceRequest {
	
	@Nullable
	int seq;
	
	@Nullable
	String name;
	
	@Nullable
	String address;
	
	@Nullable
	int page;
	
	@Nullable
	String search;
}