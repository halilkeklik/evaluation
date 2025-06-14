package com.example.evaluation.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BusinessRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Business business;
    @OneToMany(mappedBy = "businessRating", cascade = CascadeType.ALL)
    private List<RatingTypeMapping> ratingTypes;

    private String comment;
}

