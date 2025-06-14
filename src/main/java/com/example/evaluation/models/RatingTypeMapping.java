package com.example.evaluation.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RatingTypeMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RatingType ratingType;

    @ManyToOne
    private BusinessRating businessRating;

    @ManyToOne
    private ProductRating productRating;

    @ManyToOne
    private EmployeeRating employeeRating;
}
