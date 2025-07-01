package com.example.evaluation.contoller;


import com.example.evaluation.dtos.BusinessDto;
import com.example.evaluation.service.BusinessService;
import com.example.evaluation.service.RatingTypeMappingService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    private final BusinessService service;

    public BusinessController(BusinessService service, RatingTypeMappingService ratingTypeMappingService) {
        this.service = service;
    }

    @PostMapping
    public BusinessDto create(@RequestBody BusinessDto dto) {
        return service.createBusiness(dto);
    }

    @GetMapping
    public List<BusinessDto> getAll() {
        return service.getAllBusinesses();
    }

    @GetMapping("/{id}")
    public BusinessDto getById(@PathVariable Long id) {
        return service.getBusinessById(id);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{id}")
    public BusinessDto update(@PathVariable Long id, @RequestBody BusinessDto dto) {
        return service.updateBusiness(id, dto);
    }

    @GetMapping("/search")
    public BusinessDto getByName(@RequestParam String name) {
        return service.getByName(name);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBusiness(id);
    }

    @GetMapping("/top-rated")
    public BusinessDto getTopRatedBusiness() {
        return service.getAllBusinesses().stream()
                .filter(b -> b.getAvgRating() != null)
                .max(Comparator.comparingDouble(BusinessDto::getAvgRating))
                .orElse(null);
    }

}
