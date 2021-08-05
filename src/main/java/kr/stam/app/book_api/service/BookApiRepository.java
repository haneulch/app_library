package kr.stam.app.book_api.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.stam.app.entity.BookInfo;

@Repository
public interface BookApiRepository extends JpaRepository<BookInfo, Integer>{
	BookInfo findByIsbn(String string);
}
