package com.example.evaluation.models;

import jakarta.persistence.*;
@Entity
public class RatingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int value;
}
