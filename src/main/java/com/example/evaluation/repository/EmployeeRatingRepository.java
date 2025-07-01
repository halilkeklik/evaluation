package com.example.evaluation.repository;

import com.example.evaluation.models.EmployeeRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRatingRepository extends JpaRepository<EmployeeRating, Long> {
}
