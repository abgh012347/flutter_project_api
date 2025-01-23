package com.example.flutterprojectbackend.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationInfoDto {
	private Integer id;
	private Integer categoryId;
	private Integer resourceId;
	private Integer languageId;
	private String placeName;
	private String placeDescription;
	private String placeSubway;
	private String placeAddress;
	private String imgSrc;
}