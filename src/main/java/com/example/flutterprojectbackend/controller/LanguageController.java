package com.example.flutterprojectbackend.controller;

import com.example.flutterprojectbackend.data.dto.LanguageDto;
import com.example.flutterprojectbackend.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/languages")
public class LanguageController {
	
	private final LanguageService languageService;
	
	@GetMapping
	public ResponseEntity<List<LanguageDto>> getAllLanguages() {
		List<LanguageDto> languages = languageService.getAllLanguages();
		return ResponseEntity.ok(languages);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LanguageDto> getLanguageById(@PathVariable Integer id) {
		LanguageDto language = languageService.getLanguageById(id);
		return ResponseEntity.ok(language);
	}
	
//	@PostMapping
//	public ResponseEntity<LanguageDto> saveLanguage(@RequestBody LanguageDto languageDto) {
//		LanguageDto savedLanguage = languageService.saveLanguage(languageDto);
//		return ResponseEntity.ok(savedLanguage);
//	}
}