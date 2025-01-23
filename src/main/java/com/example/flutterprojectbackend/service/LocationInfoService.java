package com.example.flutterprojectbackend.service;

import com.example.flutterprojectbackend.data.dto.LocationInfoDto;
import com.example.flutterprojectbackend.data.entity.LocationInfo;
import com.example.flutterprojectbackend.data.repository.LocationInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationInfoService {
	
	private final LocationInfoRepository locationInfoRepository;
	
	public List<LocationInfoDto> getAllLocationInfos() {
		return locationInfoRepository.findAll().stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	public LocationInfoDto getLocationInfoById(Integer id) {
		LocationInfo location = locationInfoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Location not found with id: " + id));
		return convertToDto(location);
	}
	
	public LocationInfoDto saveLocationInfo(LocationInfoDto locationDto) {
		LocationInfo location = convertToEntity(locationDto);
		LocationInfo savedLocation = locationInfoRepository.save(location);
		return convertToDto(savedLocation);
	}
	
	public List<LocationInfoDto> getLocationsByKeyword(String keyword) {
		return locationInfoRepository
				.findByPlaceNameContainingOrPlaceAddressContaining(keyword, keyword) // 동일한 키워드 사용
				.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	private LocationInfoDto convertToDto(LocationInfo locationInfo) {
		return LocationInfoDto.builder()
				.id(locationInfo.getId())
				.categoryId(locationInfo.getCategory() != null ? locationInfo.getCategory().getId() : null)
				.resourceId(locationInfo.getResource() != null ? locationInfo.getResource().getId() : null)
				.languageId(locationInfo.getLanguage() != null ? locationInfo.getLanguage().getId() : null)
				.placeName(locationInfo.getPlaceName())
				.placeDescription(locationInfo.getPlaceDescription())
				.placeSubway(locationInfo.getPlaceSubway())
				.placeAddress(locationInfo.getPlaceAddress())
				.imgSrc(locationInfo.getImgSrc())
				.build();
	}
	
	private LocationInfo convertToEntity(LocationInfoDto locationDto) {
		LocationInfo locationInfo = new LocationInfo();
		locationInfo.setId(locationDto.getId());
		locationInfo.setPlaceName(locationDto.getPlaceName());
		locationInfo.setPlaceDescription(locationDto.getPlaceDescription());
		locationInfo.setPlaceSubway(locationDto.getPlaceSubway());
		locationInfo.setPlaceAddress(locationDto.getPlaceAddress());
		locationInfo.setImgSrc(locationDto.getImgSrc());
		return locationInfo;
	}
}