package kr.stam.app.dto;

import org.springframework.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class DataTestRequest {
	
	String str;
	
	@Nullable
	int number;
	
	@Nullable
	boolean booleanValue;
	
	
}
