package com.example.evaluation.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ProductRatingDto {
    private Long userId;
    private Long productId;
    private List<RatingTypeMappingDto> ratingTypes;
    private String comment;
}

