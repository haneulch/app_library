package kr.stam.app.book_api;

import kr.stam.app.dto.BookApiDataResponse;
import kr.stam.app.entity.BookInfo;

public class BookApiUtils {
	public static BookInfo dataToEntity(BookApiDataResponse book) {
		return BookInfo
				.builder()
				.author(book.getAuthor())
				.isbn(book.getEaIsbn())
				.title(book.getTitle())
				.thumbImg(book.getTitleUrl())
				.publisher(book.getPublisher())
				.price(book.getPrePrice().equals("") ? 0 : Integer.parseInt(book.getPrePrice()))
				.build();
	}
}