package com.example.evaluation.repository;

import com.example.evaluation.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    Optional<Business> findByName(String name);
}
