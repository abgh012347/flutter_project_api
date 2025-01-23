package com.example.flutterprojectbackend.data.repository;

import com.example.flutterprojectbackend.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	// 특정 이름(category)을 가진 카테고리 검색
	List<Category> findByCategory(String category);
	
	// 특정 languageId를 가진 모든 카테고리 검색
	List<Category> findByLanguageId(Integer languageId);
	
	// 등록 날짜 기준 이후의 모든 카테고리 검색
	List<Category> findByRegDateAfter(Instant regDate);
	
	// 특정 resourceId를 가진 카테고리 검색
	List<Category> findByResourceId(Integer resourceId);
}