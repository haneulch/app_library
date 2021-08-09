package kr.library.app.main.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.library.app.entity.FileTest;

@Repository
public interface MainRepository extends JpaRepository<FileTest, Integer>{

	
}
