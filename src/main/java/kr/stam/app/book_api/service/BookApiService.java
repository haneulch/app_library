package kr.stam.app.book_api.service;

import java.util.List;

import kr.stam.app.dto.BookApiDataResponse;
import kr.stam.app.entity.BookInfo;
import kr.stam.app.entity.Category;

public interface BookApiService {
	public void saveAll(List<BookApiDataResponse> list);
	public BookInfo save(BookInfo bookInfo);
	public BookInfo findByIsbn(String string);
	public Category saveCategory(Category category);
	public Category findCategoryByCateName(String cateName);
	public void updateBookInfo(BookInfo book);
}
