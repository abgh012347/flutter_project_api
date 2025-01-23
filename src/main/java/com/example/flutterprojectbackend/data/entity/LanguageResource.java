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
@Table(name = "language_resource", schema = "flutter_project")
public class LanguageResource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id", nullable = true)
	private Language language;
	
	@Column(name = "resource", length = 100)
	private String resource;
	
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