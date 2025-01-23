package com.example.flutterprojectbackend.controller;

import com.example.flutterprojectbackend.data.dto.CategoryDto;
import com.example.flutterprojectbackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		List<CategoryDto> categories = categoryService.getAllCategories();
		return ResponseEntity.ok(categories);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id) {
		CategoryDto category = categoryService.getCategoryById(id);
		return ResponseEntity.ok(category);
	}
	
	@GetMapping("/language/{languageId}")
	public ResponseEntity<List<CategoryDto>> getCategoriesByLanguageId(@PathVariable Integer languageId) {
		List<CategoryDto> categories = categoryService.getCategoriesByLanguageId(languageId);
		return ResponseEntity.ok(categories);
	}
	
	@PostMapping
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto savedCategory = categoryService.saveCategory(categoryDto);
		return ResponseEntity.ok(savedCategory);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
}