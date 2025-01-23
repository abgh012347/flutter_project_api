package com.example.flutterprojectbackend.data.repository;

import com.example.flutterprojectbackend.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	// 특정 languageId를 가진 모든 카테고리 검색
	List<Category> findByLanguageId(Integer languageId);
	
}