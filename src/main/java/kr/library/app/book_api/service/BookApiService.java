package kr.library.app.book_api.service;

import java.util.List;

import kr.library.app.dto.BookApiDataResponse;
import kr.library.app.entity.BookInfo;
import kr.library.app.entity.Category;

public interface BookApiService {
	public void saveAll(List<BookApiDataResponse> list);
	public BookInfo save(BookInfo bookInfo);
	public BookInfo findByIsbn(String string);
	public Category saveCategory(Category category);
	public Category findCategoryByCateName(String cateName);
	public void updateBookInfo(BookInfo book);
}
