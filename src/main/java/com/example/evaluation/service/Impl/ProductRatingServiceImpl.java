package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.ProductRatingDto;
import com.example.evaluation.mapper.ProductRatingMapper;
import com.example.evaluation.models.ProductRating;
import com.example.evaluation.repository.ProductRatingRepository;
import com.example.evaluation.service.ProductRatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductRatingServiceImpl implements ProductRatingService {

    private final ProductRatingRepository repository;
    private final ProductRatingMapper mapper;

    public ProductRatingServiceImpl(ProductRatingRepository repository, ProductRatingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductRatingDto createProductRating(ProductRatingDto dto) {
        ProductRating entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<ProductRatingDto> getAllProductRatings() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductRatingDto getProductRatingById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public ProductRatingDto updateProductRating(Long id, ProductRatingDto dto) {
        if (!repository.existsById(id)) return null;
        ProductRating entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteProductRating(Long id) {
        repository.deleteById(id);
    }
}
