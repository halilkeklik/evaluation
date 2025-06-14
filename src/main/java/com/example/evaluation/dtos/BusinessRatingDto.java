package com.example.evaluation.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BusinessRatingDto {
    private Long userId;
    private Long businessId;
    private List<RatingTypeMappingDto> ratingTypes;
    private String comment;
}
