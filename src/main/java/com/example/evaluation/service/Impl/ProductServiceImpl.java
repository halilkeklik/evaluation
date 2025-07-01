package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.EmployeeDto;
import com.example.evaluation.dtos.ProductDto;
import com.example.evaluation.mapper.ProductMapper;
import com.example.evaluation.models.Product;
import com.example.evaluation.repository.ProductRepository;
import com.example.evaluation.service.ProductService;
import com.example.evaluation.service.RatingTypeMappingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final RatingTypeMappingService ratingTypeMappingService;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper, RatingTypeMappingService ratingTypeMappingService) {
        this.repository = repository;
        this.mapper = mapper;
        this.ratingTypeMappingService = ratingTypeMappingService;
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {
        Product entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductDto dto = repository.findById(id).map(mapper::toDto).orElse(null);
        assert false;
        dto.setAvgRating(ratingTypeMappingService.findAverageRatingByProductId(id));
        return dto;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto dto) {
        if (!repository.existsById(id)) return null;
        Product entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
