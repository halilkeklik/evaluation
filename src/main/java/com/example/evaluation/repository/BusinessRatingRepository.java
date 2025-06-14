package com.example.evaluation.repository;

import com.example.evaluation.models.BusinessRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRatingRepository extends JpaRepository<BusinessRating, Long> {
}