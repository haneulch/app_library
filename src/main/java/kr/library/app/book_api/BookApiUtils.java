package kr.library.app.book_api;

import kr.library.app.dto.BookApiDataResponse;
import kr.library.app.entity.BookInfo;

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