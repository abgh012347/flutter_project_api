package com.example.flutterprojectbackend.service;

import com.example.flutterprojectbackend.data.dto.CategoryDto;
import com.example.flutterprojectbackend.data.entity.Category;
import com.example.flutterprojectbackend.data.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public List<CategoryDto> getAllCategories() {
		return categoryRepository.findAll().stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	public CategoryDto saveCategory(CategoryDto categoryDto) {
		Category category = convertToEntity(categoryDto);
		Category savedCategory = categoryRepository.save(category);
		return convertToDto(savedCategory);
	}
	
	public CategoryDto getCategoryById(Integer id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Category not found with id: " + id));
		return convertToDto(category);
	}
	
	public List<CategoryDto> getCategoriesByLanguageId(Integer languageId) {
		return categoryRepository.findByLanguageId(languageId).stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	public void deleteCategory(Integer id) {
		if (!categoryRepository.existsById(id)) {
			throw new IllegalStateException("Category not found with id: " + id);
		}
		categoryRepository.deleteById(id);
	}
	
	private CategoryDto convertToDto(Category category) {
		return CategoryDto.builder()
				.id(category.getId())
				.resourceId(category.getResource() != null ? category.getResource().getId() : null)
				.languageId(category.getLanguage() != null ? category.getLanguage().getId() : null)
				.category(category.getCategory())
				.build();
	}
	
	private Category convertToEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setCategory(categoryDto.getCategory());
		category.setUpDate(Instant.now());
		return category;
	}
}