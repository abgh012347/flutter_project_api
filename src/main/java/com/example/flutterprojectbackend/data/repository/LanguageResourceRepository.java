package com.example.flutterprojectbackend.data.repository;

import com.example.flutterprojectbackend.data.entity.LanguageResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LanguageResourceRepository extends JpaRepository<LanguageResource, Integer> {
	
	// 특정 language ID로 리소스를 검색
	List<LanguageResource> findByLanguageId(Integer languageId);
	
}