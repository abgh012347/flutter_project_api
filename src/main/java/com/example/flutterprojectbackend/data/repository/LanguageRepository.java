package com.example.flutterprojectbackend.data.repository;

import com.example.flutterprojectbackend.data.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
	
	// 특정 언어 이름(language)을 가진 Language 검색 (예: "English")
	Optional<Language> findByLanguage(String language);
	
	// 언어 이름이 포함된 모든 Language 목록 검색 (예: "en"으로 시작하는 모든 언어)
	List<Language> findByLanguageStartingWith(String prefix);
	
	// ID 내림차순으로 모든 언어 정렬
	List<Language> findAllByOrderByIdDesc();
}