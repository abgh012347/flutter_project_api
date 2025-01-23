package com.example.flutterprojectbackend.data.repository;

import com.example.flutterprojectbackend.data.entity.LanguageResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.Instant;

@Repository
public interface LanguageResourceRepository extends JpaRepository<LanguageResource, Integer> {
	
	// 특정 language ID로 리소스를 검색
	List<LanguageResource> findByLanguageId(Integer languageId);
	
	// 리소스 이름(resource)에 특정 키워드가 포함된 항목 검색
	List<LanguageResource> findByResourceContaining(String keyword);
	
	// 등록 날짜 이후의 모든 리소스 검색
	List<LanguageResource> findByRegDateAfter(Instant regDate);
	
	// 리소스 ID 내림차순으로 정렬하여 모든 리소스 검색
	List<LanguageResource> findAllByOrderByIdDesc();
}