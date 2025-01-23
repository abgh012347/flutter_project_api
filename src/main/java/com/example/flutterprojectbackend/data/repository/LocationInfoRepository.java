package com.example.flutterprojectbackend.data.repository;

import com.example.flutterprojectbackend.data.entity.LocationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.Instant;

@Repository
public interface LocationInfoRepository extends JpaRepository<LocationInfo, Integer> {
	
	// 특정 카테고리(categoryId)로 장소 검색
	List<LocationInfo> findByCategoryId(Integer categoryId);
	
	// 특정 리소스(resourceId)로 장소 검색
	List<LocationInfo> findByResourceId(Integer resourceId);
	
	// 특정 언어(languageId)로 장소 검색
	List<LocationInfo> findByLanguageId(Integer languageId);
	
	// 장소 이름(placeName)이나 주소(placeAddress)에 검색어가 포함된 결과를 검색
	List<LocationInfo> findByPlaceNameContainingOrPlaceAddressContaining(String placeNameKeyword, String addressKeyword);
	
	// 등록 날짜 이후 모든 장소 검색
	List<LocationInfo> findByRegDateAfter(Instant regDate);
	
	// 이미지 소스(imgSrc)가 NULL이 아닌 데이터를 검색
	List<LocationInfo> findByImgSrcIsNotNull();
}