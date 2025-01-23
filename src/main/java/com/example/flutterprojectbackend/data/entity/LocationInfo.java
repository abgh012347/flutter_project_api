package com.example.flutterprojectbackend.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "location_info", schema = "flutter_project")
public class LocationInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id", nullable = false)
	private Language language;
	
	@Column(name = "place_name", length = 50)
	private String placeName;
	
	@Column(name = "place_description")
	private String placeDescription;
	
	@Column(name = "place_subway")
	private String placeSubway;
	
	@Column(name = "place_address")
	private String placeAddress;
	
	@Column(name = "img_src", length = 500)
	private String imgSrc;
	
	@Column(name = "reg_date", updatable = false)
	private Instant regDate;
	
	@Column(name = "up_date")
	private Instant upDate;
	
	@PrePersist
	public void prePersist() {
		Instant now = Instant.now();
		regDate = now;
		upDate = now;
	}
	
	@PreUpdate
	public void preUpdate() {
		upDate = Instant.now();
	}
}