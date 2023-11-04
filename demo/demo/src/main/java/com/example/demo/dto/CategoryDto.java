package com.example.demo.dto;

import com.example.demo.entity.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CategoryDto {
    private Long id;
    private String name;

    private List<Product> products;
}
