package com.example.evaluation.mapper;

import com.example.evaluation.dtos.RatingTypeMappingDto;
import com.example.evaluation.models.RatingTypeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RatingTypeMappingMapper {

    @Mapping(target = "ratingType.id", source = "ratingTypeId")
    @Mapping(target = "businessRating.id", source = "businessRatingId")
    @Mapping(target = "productRating.id", source = "productRatingId")
    @Mapping(target = "employeeRating.id", source = "employeeRatingId")
    RatingTypeMapping toEntity(RatingTypeMappingDto dto);

    @Mapping(source = "ratingType.id", target = "ratingTypeId")
    @Mapping(source = "businessRating.id", target = "businessRatingId")
    @Mapping(source = "productRating.id", target = "productRatingId")
    @Mapping(source = "employeeRating.id", target = "employeeRatingId")
    RatingTypeMappingDto toDto(RatingTypeMapping entity);
}
