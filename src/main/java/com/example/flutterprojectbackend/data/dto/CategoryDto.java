package com.example.flutterprojectbackend.data.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {
	private Integer id;
	private Integer resourceId;
	private Integer languageId;
	private String category;
}