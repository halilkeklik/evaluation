package com.example.evaluation.mapper;
import com.example.evaluation.dtos.RatingTypeDto;
import com.example.evaluation.models.RatingType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RatingTypeMapper {

    RatingTypeMapper INSTANCE = Mappers.getMapper(RatingTypeMapper.class);

    RatingTypeDto toDto(RatingType ratingType);

    RatingType toEntity(RatingTypeDto dto);
}

