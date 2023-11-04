package com.example.demo.dto;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewDto {
    private Long id;
    private String comment;

    private User user;

    private Product product;
}
