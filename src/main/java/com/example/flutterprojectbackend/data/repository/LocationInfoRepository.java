package com.example.flutterprojectbackend.data.repository;

import com.example.flutterprojectbackend.data.entity.LocationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationInfoRepository extends JpaRepository<LocationInfo, Integer> {
	
	// 지역 주소(addressKeyword)로만 검색하도록 수정
	List<LocationInfo> findByPlaceAddressContaining(String addressKeyword);
	
}