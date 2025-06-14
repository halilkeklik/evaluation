package com.example.evaluation.dtos;

import lombok.Data;

@Data
public class RatingTypeMappingDto {
    private Long id;

    private Long ratingTypeId;

    private Long businessRatingId;

    private Long productRatingId;

    private Long employeeRatingId;
}
