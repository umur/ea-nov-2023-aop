package com.example.lab3.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private double rating;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private  Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
