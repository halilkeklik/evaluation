package com.example.evaluation.models;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

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
