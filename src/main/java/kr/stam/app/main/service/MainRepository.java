package kr.stam.app.main.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.stam.app.entity.FileTest;

@Repository
public interface MainRepository extends JpaRepository<FileTest, Integer>{

	
}
