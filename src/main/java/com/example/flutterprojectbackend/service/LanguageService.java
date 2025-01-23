package com.example.flutterprojectbackend.service;

import com.example.flutterprojectbackend.data.dto.LanguageDto;
import com.example.flutterprojectbackend.data.entity.Language;
import com.example.flutterprojectbackend.data.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageService {
	
	private final LanguageRepository languageRepository;
	
	public List<LanguageDto> getAllLanguages() {
		return languageRepository.findAll().stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	public LanguageDto getLanguageById(Integer id) {
		Language language = languageRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Language not found with id: " + id));
		return convertToDto(language);
	}
	
	public LanguageDto saveLanguage(LanguageDto languageDto) {
		Language language = convertToEntity(languageDto);
		Language savedLanguage = languageRepository.save(language);
		return convertToDto(savedLanguage);
	}
	
	private LanguageDto convertToDto(Language language) {
		return LanguageDto.builder()
				.id(language.getId())
				.language(language.getLanguage())
				.build();
	}
	
	private Language convertToEntity(LanguageDto languageDto) {
		Language language = new Language();
		language.setId(languageDto.getId());
		language.setLanguage(languageDto.getLanguage());
		return language;
	}
}