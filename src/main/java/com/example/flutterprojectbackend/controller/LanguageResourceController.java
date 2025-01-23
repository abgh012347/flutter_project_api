package com.example.flutterprojectbackend.controller;

import com.example.flutterprojectbackend.data.dto.LanguageResourceDto;
import com.example.flutterprojectbackend.service.LanguageResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/resources")
public class LanguageResourceController {
	
	private final LanguageResourceService languageResourceService;
	
	@GetMapping("/language/{languageId}")
	public ResponseEntity<List<LanguageResourceDto>> getResourcesByLanguageId(@PathVariable Integer languageId) {
		List<LanguageResourceDto> resources = languageResourceService.getResourcesByLanguageId(languageId);
		return ResponseEntity.ok(resources);
	}
	
//	@PostMapping
//	public ResponseEntity<LanguageResourceDto> saveResource(@RequestBody LanguageResourceDto resourceDto) {
//		LanguageResourceDto savedResource = languageResourceService.saveResource(resourceDto);
//		return ResponseEntity.ok(savedResource);
//	}
}