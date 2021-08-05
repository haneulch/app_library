package kr.stam.app.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookApiResponse {
	
	@JsonProperty(value = "PAGE_NO", access = Access.WRITE_ONLY)
	String pageNo;
	
	@JsonProperty(value = "TOTAL_COUNT", access = Access.WRITE_ONLY)
	String totalCount;
	
	List<BookApiDataResponse> docs;
}
