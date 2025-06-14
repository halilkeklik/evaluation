package com.example.evaluation.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Business business;

    @OneToMany(mappedBy = "product")
    private List<ProductRating> ratings;
}
