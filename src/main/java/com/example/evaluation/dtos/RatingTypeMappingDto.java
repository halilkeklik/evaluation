package com.example.evaluation.dtos;

import lombok.Data;

@Data
public class RatingTypeMappingDto {
    private Long id;

    private Long ratingTypeId;

    private Long businessRatingId;

    private Double businessAvgRating;

    private Long productRatingId;

    private Double productAvgRating;

    private Long employeeRatingId;

    private Double employeeAvgRating;

}
