package com.example.demo.dto;

import com.example.demo.entity.Category;
import com.example.demo.entity.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private double rating;

    private Category category;

    private List<Review> reviews;
}
