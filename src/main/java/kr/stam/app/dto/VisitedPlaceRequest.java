package kr.stam.app.dto;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitedPlaceRequest {

	@Nullable
	String username;
	
	@Nullable
	int seq;
	
	@Nullable
	int placeSeq;
}