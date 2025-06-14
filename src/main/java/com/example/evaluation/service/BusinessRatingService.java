package com.example.evaluation.service;

import com.example.evaluation.dtos.BusinessRatingDto;

import java.util.List;

public interface BusinessRatingService {
    BusinessRatingDto createBusinessRating(BusinessRatingDto dto);
    List<BusinessRatingDto> getAllBusinessRatings();
    BusinessRatingDto getBusinessRatingById(Long id);
    BusinessRatingDto updateBusinessRating(Long id, BusinessRatingDto dto);
    void deleteBusinessRating(Long id);
}
