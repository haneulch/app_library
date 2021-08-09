package kr.library.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookApiDataResponse {
	
	@JsonProperty(value = "SUBJECT")
	String subject;
	
	@JsonProperty(value = "AUTHOR")
	String author;
	
	@JsonProperty(value = "REAL_PUBLISH_DATE")
	String realPublishDate;
	
	@JsonProperty(value = "UPDATE_DATE")
	String updateDate;
	
	@JsonProperty(value = "EA_ISBN")
	String eaIsbn;
	
	@JsonProperty(value = "PUBLISHER")
	String publisher;
	
	@JsonProperty(value = "SET_ADD_CODE")
	String setAddCode;
	
	@JsonProperty(value = "SERIES_NO")
	String seriesNo;
	
	@JsonProperty(value = "TITLE_URL")
	String titleUrl;
	
	@JsonProperty(value = "PUBLISH_PREDATE")
	String publishPredate;
	
	@JsonProperty(value = "EA_ADD_CODE")
	String eaAddCode;
	
	@JsonProperty(value = "SET_EXPRESSION")
	String setExpression;
	
	@JsonProperty(value = "FORM_DETAIL")
	String formDetail;
	
	@JsonProperty(value = "BIB_YN")
	String bibYn;
	
	@JsonProperty(value = "CIP_YN")
	String cipYn;
	
	@JsonProperty(value = "EBOOK_YN")
	String ebookYn;
	
	@JsonProperty(value = "SET_ISBN")
	String setIsbn;
	
	@JsonProperty(value = "DDC")
	String ddc;
	
	@JsonProperty(value = "BOOK_SUMMARY_URL")
	String bookSummaryUrl;
	
	@JsonProperty(value = "SERIES_TITLE")
	String seriesTitle;
	
	@JsonProperty(value = "BOOK_INTRODUCTION_URL")
	String bookIntroductionUrl;
	
	@JsonProperty(value = "PAGE")
	String page;
	
	@JsonProperty(value = "EDITION_STMT")
	String editionStmt;
	
	@JsonProperty(value = "CONTROL_NO")
	String controlNo;
	
	@JsonProperty(value = "INPUT_DATE")
	String inputDate;
	
	@JsonProperty(value = "REAL_PRICE")
	String realPrice;
	
	@JsonProperty(value = "BOOK_TB_CNT_URL")
	String bookTbCntUrl;
	
	@JsonProperty(value = "VOL")
	String vol;
	
	@JsonProperty(value = "FORM")
	String form;
	
	@JsonProperty(value = "PRE_PRICE")
	String prePrice;
	
	@JsonProperty(value = "PUBLISHER_URL")
	String publisherUrl;
	
	@JsonProperty(value = "BOOK_SIZE")
	String bookSize;
	
	@JsonProperty(value = "DEPOSIT_YN")
	String depositYn;
	
	@JsonProperty(value = "RELATED_ISBN")
	String relatedIsbn;
	
	@JsonProperty(value = "KDC")
	String kdc;
	
	@JsonProperty(value = "TITLE")
	String title;
}
