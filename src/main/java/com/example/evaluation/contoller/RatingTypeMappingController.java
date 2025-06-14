package com.example.evaluation.contoller;

import com.example.evaluation.dtos.RatingTypeMappingDto;
import com.example.evaluation.service.RatingTypeMappingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratingtypemappings")
public class RatingTypeMappingController {

    private final RatingTypeMappingService service;

    public RatingTypeMappingController(RatingTypeMappingService service) {
        this.service = service;
    }

    @PostMapping
    public RatingTypeMappingDto create(@RequestBody RatingTypeMappingDto dto) {
        return service.createRatingTypeMapping(dto);
    }

    @GetMapping
    public List<RatingTypeMappingDto> getAll() {
        return service.getAllRatingTypeMappings();
    }

    @GetMapping("/{id}")
    public RatingTypeMappingDto getById(@PathVariable Long id) {
        return service.getRatingTypeMappingById(id);
    }

    @PutMapping("/{id}")
    public RatingTypeMappingDto update(@PathVariable Long id, @RequestBody RatingTypeMappingDto dto) {
        return service.updateRatingTypeMapping(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRatingTypeMapping(id);
    }
}
