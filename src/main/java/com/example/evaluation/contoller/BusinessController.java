package com.example.evaluation.contoller;


import com.example.evaluation.dtos.BusinessDto;
import com.example.evaluation.service.BusinessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    private final BusinessService service;

    public BusinessController(BusinessService service) {
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

    @PutMapping("/{id}")
    public BusinessDto update(@PathVariable Long id, @RequestBody BusinessDto dto) {
        return service.updateBusiness(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBusiness(id);
    }
}
