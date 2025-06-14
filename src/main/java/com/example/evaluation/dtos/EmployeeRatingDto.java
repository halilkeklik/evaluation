package com.example.evaluation.dtos;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeRatingDto {
    private Long userId;
    private Long employeeId;
    private List<RatingTypeMappingDto> ratingTypes;
    private String comment;
}
