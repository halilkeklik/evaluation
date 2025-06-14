package com.example.evaluation.mapper;

import com.example.evaluation.dtos.ProductDto;
import com.example.evaluation.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // Spring ile entegrasyon için
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "business.id", target = "businessId")
    ProductDto toDto(Product product);

    @Mapping(source = "businessId", target = "business.id")
    Product toEntity(ProductDto dto);
}

