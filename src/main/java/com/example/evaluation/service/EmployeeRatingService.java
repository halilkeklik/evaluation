package com.example.evaluation.service;

import com.example.evaluation.dtos.EmployeeRatingDto;

import java.util.List;

public interface EmployeeRatingService {
    EmployeeRatingDto createEmployeeRating(EmployeeRatingDto dto);
    List<EmployeeRatingDto> getAllEmployeeRatings();
    EmployeeRatingDto getEmployeeRatingById(Long id);
    EmployeeRatingDto updateEmployeeRating(Long id, EmployeeRatingDto dto);
    void deleteEmployeeRating(Long id);
}
