package com.example.flutterprojectbackend.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "language", schema = "flutter_project")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "language", length = 10)
	private String language;
	
	@Column(name = "reg_date", updatable = false)
	private Instant regDate;
	
	@Column(name = "up_date")
	private Instant upDate;
	
	@OneToMany(mappedBy = "language", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LocationInfo> locationInfos = new ArrayList<>();
	
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