package com.example.flutterprojectbackend.service;

import com.example.flutterprojectbackend.data.dto.LanguageResourceDto;
import com.example.flutterprojectbackend.data.entity.LanguageResource;
import com.example.flutterprojectbackend.data.repository.LanguageResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageResourceService {
	
	private final LanguageResourceRepository languageResourceRepository;
	
	public List<LanguageResourceDto> getAllResources() {
		return languageResourceRepository.findAll().stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	public LanguageResourceDto saveResource(LanguageResourceDto resourceDto) {
		LanguageResource resource = convertToEntity(resourceDto);
		LanguageResource savedResource = languageResourceRepository.save(resource);
		return convertToDto(savedResource);
	}
	
	public List<LanguageResourceDto> getResourcesByLanguageId(Integer languageId) {
		return languageResourceRepository.findByLanguageId(languageId).stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	private LanguageResourceDto convertToDto(LanguageResource resource) {
		return LanguageResourceDto.builder()
				.id(resource.getId())
				.languageId(resource.getLanguage() != null ? resource.getLanguage().getId() : null)
				.resource(resource.getResource())
				.build();
	}
	
	private LanguageResource convertToEntity(LanguageResourceDto resourceDto) {
		LanguageResource resource = new LanguageResource();
		resource.setId(resourceDto.getId());
		resource.setResource(resourceDto.getResource());
		return resource;
	}
}