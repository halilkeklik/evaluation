package com.example.evaluation.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ProductRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    @OneToMany(mappedBy = "productRating", cascade = CascadeType.ALL)
    private List<RatingTypeMapping> ratingTypes;

    private String comment;
}
