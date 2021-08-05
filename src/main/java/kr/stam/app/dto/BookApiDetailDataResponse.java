package kr.stam.app.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookApiDetailDataResponse {
	int total;
	String kwd;
	int pageNum;
	int pageSize;
	String category;
	String sort;
	List<BookApiDetailResponse> result;
}