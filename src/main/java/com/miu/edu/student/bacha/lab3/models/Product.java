package com.miu.edu.student.bacha.lab3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String rating;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
