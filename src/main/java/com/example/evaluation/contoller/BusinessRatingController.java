package com.example.evaluation.contoller;

import com.example.evaluation.dtos.BusinessRatingDto;
import com.example.evaluation.service.BusinessRatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/businessratings")
public class BusinessRatingController {

    private final BusinessRatingService service;

    public BusinessRatingController(BusinessRatingService service) {
        this.service = service;
    }

    @PostMapping
    public BusinessRatingDto create(@RequestBody BusinessRatingDto dto) {
        return service.createBusinessRating(dto);
    }

    @GetMapping
    public List<BusinessRatingDto> getAll() {
        return service.getAllBusinessRatings();
    }

    @GetMapping("/{id}")
    public BusinessRatingDto getById(@PathVariable Long id) {
        return service.getBusinessRatingById(id);
    }

    @PutMapping("/{id}")
    public BusinessRatingDto update(@PathVariable Long id, @RequestBody BusinessRatingDto dto) {
        return service.updateBusinessRating(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBusinessRating(id);
    }
}
