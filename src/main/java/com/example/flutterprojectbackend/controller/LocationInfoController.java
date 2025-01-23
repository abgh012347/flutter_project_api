package com.example.flutterprojectbackend.controller;

import com.example.flutterprojectbackend.data.dto.LocationInfoDto;
import com.example.flutterprojectbackend.service.LocationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/locations")
public class LocationInfoController {
	
	private final LocationInfoService locationInfoService;
	
	@GetMapping("/search")
	public ResponseEntity<List<LocationInfoDto>> getLocationsByKeyword(@RequestParam String keyword) {
		List<LocationInfoDto> locations = locationInfoService.getLocationsByKeyword(keyword);
		return ResponseEntity.ok(locations);
	}
	
//	@PostMapping
//	public ResponseEntity<LocationInfoDto> saveLocationInfo(@RequestBody LocationInfoDto locationDto) {
//		LocationInfoDto savedLocation = locationInfoService.saveLocationInfo(locationDto);
//		return ResponseEntity.ok(savedLocation);
//	}
}