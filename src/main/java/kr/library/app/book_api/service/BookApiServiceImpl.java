package kr.library.app.book_api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import kr.library.app.book_api.BookApiUtils;
import kr.library.app.category.service.CategoryRepository;
import kr.library.app.dto.BookApiDataResponse;
import kr.library.app.entity.BookInfo;
import kr.library.app.entity.Category;

@Service
public class BookApiServiceImpl implements BookApiService {
	
	private final BookApiRepository bookApiRepository;
	private final CategoryRepository categoryRepository;
	
	private BookApiServiceImpl(
			BookApiRepository bookApiRepository
			, CategoryRepository categoryRepository) {
		this.bookApiRepository = bookApiRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public BookInfo save(BookInfo book) {
		bookApiRepository.save(book);
		bookApiRepository.flush();
		return book;
	}

	@Override
	public void saveAll(List<BookApiDataResponse> list) {
		List<BookInfo> books = new ArrayList<BookInfo>();
		list.stream().forEach(book -> books.add(BookApiUtils.dataToEntity(book)));
		
		bookApiRepository.saveAll(books);
	}

	@Override
	public BookInfo findByIsbn(String string) {
		return bookApiRepository.findByIsbn(string);
	}

	@Override
	public Category saveCategory(Category category) {
		categoryRepository.save(category);
		categoryRepository.flush();
		return category;
	}

	@Override
	public Category findCategoryByCateName(String cateName) {
		return categoryRepository.findByCateName(cateName);
	}

	@Override
	public void updateBookInfo(BookInfo book) {
		bookApiRepository.save(book);
	}
}
