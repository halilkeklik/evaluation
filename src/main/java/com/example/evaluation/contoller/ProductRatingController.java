package com.example.evaluation.contoller;

import com.example.evaluation.dtos.ProductRatingDto;
import com.example.evaluation.service.ProductRatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productRatings")
public class ProductRatingController {

    private final ProductRatingService service;

    public ProductRatingController(ProductRatingService service) {
        this.service = service;
    }

    @PostMapping
    public ProductRatingDto create(@RequestBody ProductRatingDto dto) {
        return service.createProductRating(dto);
    }

    @GetMapping
    public List<ProductRatingDto> getAll() {
        return service.getAllProductRatings();
    }

    @GetMapping("/{id}")
    public ProductRatingDto getById(@PathVariable Long id) {
        return service.getProductRatingById(id);
    }

    @PutMapping("/{id}")
    public ProductRatingDto update(@PathVariable Long id, @RequestBody ProductRatingDto dto) {
        return service.updateProductRating(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProductRating(id);
    }
}
