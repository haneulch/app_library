package kr.library.app.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "st_book_info")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookInfo {

	@Id
	@Column(nullable = false, columnDefinition = "INT(12) NOT NULL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int seq;

	@Column(length = 500)
	String author;

	@Column(length = 100)
	String isbn;

	@Column(length = 500)
	String title;

	@Column(length = 500)
	String thumbImg;

	@Column(length = 200)
	String publisher;

	@Column(length = 10)
	int price;
	
	@Column
	int categorySeq;
	
	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	Timestamp createdDt;
	
	@Builder
	public BookInfo(String author, String isbn, String title, String thumbImg, String publisher, int price) {
		this.author = author;
		this.isbn = isbn;
		this.title = title;
		this.thumbImg = thumbImg;
		this.publisher = publisher;
		this.price = price;
	}
}
