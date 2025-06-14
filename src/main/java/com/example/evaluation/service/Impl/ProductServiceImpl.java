package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.ProductDto;
import com.example.evaluation.mapper.ProductMapper;
import com.example.evaluation.models.Product;
import com.example.evaluation.repository.ProductRepository;
import com.example.evaluation.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
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
        return repository.findById(id).map(mapper::toDto).orElse(null);
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
