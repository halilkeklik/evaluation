package com.example.evaluation.repository;

import com.example.evaluation.models.ProductRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRatingRepository extends JpaRepository<ProductRating, Long> { }