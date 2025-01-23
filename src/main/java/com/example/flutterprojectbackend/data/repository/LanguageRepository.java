package com.example.flutterprojectbackend.data.repository;

import com.example.flutterprojectbackend.data.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}