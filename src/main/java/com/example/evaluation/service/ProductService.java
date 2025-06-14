package com.example.evaluation.service;

import com.example.evaluation.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto dto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto updateProduct(Long id, ProductDto dto);
    void deleteProduct(Long id);
}
