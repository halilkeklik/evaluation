package com.example.evaluation.service;

import com.example.evaluation.dtos.RatingTypeDto;

import java.util.List;

public interface RatingTypeService {
    RatingTypeDto createRatingType(RatingTypeDto dto);
    List<RatingTypeDto> getAllRatingTypes();
    RatingTypeDto getRatingTypeById(Long id);
    RatingTypeDto updateRatingType(Long id, RatingTypeDto dto);
    void deleteRatingType(Long id);
}
