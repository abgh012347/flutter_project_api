package com.example.flutterprojectbackend.data.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LanguageDto {
	private Integer id;
	private String language;
}