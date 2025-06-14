package com.example.evaluation.contoller;

import com.example.evaluation.dtos.ProductDto;
import com.example.evaluation.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto dto) {
        return service.createProduct(dto);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody ProductDto dto) {
        return service.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProduct(id);
    }
}
