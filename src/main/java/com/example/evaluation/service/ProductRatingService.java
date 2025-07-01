package com.example.evaluation.service;

import com.example.evaluation.dtos.ProductRatingDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRatingService {
    ProductRatingDto createProductRating(ProductRatingDto dto);
    List<ProductRatingDto> getAllProductRatings();
    ProductRatingDto getProductRatingById(Long id);
    ProductRatingDto updateProductRating(Long id, ProductRatingDto dto);
    void deleteProductRating(Long id);
}
