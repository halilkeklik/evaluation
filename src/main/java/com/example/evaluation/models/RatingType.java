package com.example.evaluation.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class RatingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int value;
}
