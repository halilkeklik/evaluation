package com.example.evaluation.service;

import com.example.evaluation.dtos.RatingTypeMappingDto;

import java.util.List;

public interface RatingTypeMappingService {
    RatingTypeMappingDto createRatingTypeMapping(RatingTypeMappingDto dto);
    List<RatingTypeMappingDto> getAllRatingTypeMappings();
    RatingTypeMappingDto getRatingTypeMappingById(Long id);
    RatingTypeMappingDto updateRatingTypeMapping(Long id, RatingTypeMappingDto dto);
    void deleteRatingTypeMapping(Long id);
}
