package com.example.evaluation.contoller;


import com.example.evaluation.dtos.RatingTypeDto;
import com.example.evaluation.service.RatingTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratingtypes")
public class RatingTypeController {

    private final RatingTypeService service;

    public RatingTypeController(RatingTypeService service) {
        this.service = service;
    }

    @PostMapping
    public RatingTypeDto create(@RequestBody RatingTypeDto dto) {
        return service.createRatingType(dto);
    }

    @GetMapping
    public List<RatingTypeDto> getAll() {
        return service.getAllRatingTypes();
    }

    @GetMapping("/{id}")
    public RatingTypeDto getById(@PathVariable Long id) {
        return service.getRatingTypeById(id);
    }

    @PutMapping("/{id}")
    public RatingTypeDto update(@PathVariable Long id, @RequestBody RatingTypeDto dto) {
        return service.updateRatingType(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRatingType(id);
    }
}
