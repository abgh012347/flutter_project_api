package com.example.flutterprojectbackend.data.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LanguageResourceDto {
	private Integer id;
	private Integer languageId;
	private String resource;
	private List<LocationInfoDto> locationInfos; // Related Location Info list
}