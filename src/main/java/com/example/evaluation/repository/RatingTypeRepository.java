package com.example.evaluation.repository;

import com.example.evaluation.models.RatingType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingTypeRepository extends JpaRepository<RatingType, Long> {
}