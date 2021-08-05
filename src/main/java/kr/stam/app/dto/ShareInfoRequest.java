package kr.stam.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShareInfoRequest {
	int bookSeq;
	int userSeq;
	String title;
	String content;
	int price;
}