package kr.library.app.category.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.library.app.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByCateName(String cateName);
}