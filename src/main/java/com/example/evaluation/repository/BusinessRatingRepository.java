package com.example.evaluation.repository;

import com.example.evaluation.models.BusinessRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRatingRepository extends JpaRepository<BusinessRating, Long> {
    List<BusinessRating> findByBusinessId(Long id);
}