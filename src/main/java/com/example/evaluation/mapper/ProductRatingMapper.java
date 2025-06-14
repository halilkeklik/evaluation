package com.example.evaluation.mapper;

import com.example.evaluation.dtos.ProductRatingDto;
import com.example.evaluation.models.ProductRating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {RatingTypeMappingMapper.class})
public interface ProductRatingMapper {

    ProductRatingMapper INSTANCE = Mappers.getMapper(ProductRatingMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "ratingTypes", target = "ratingTypes")
    ProductRatingDto toDto(ProductRating rating);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "product.id", source = "productId")
    ProductRating toEntity(ProductRatingDto dto);
}
