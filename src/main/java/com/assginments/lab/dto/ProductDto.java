package com.assginments.lab.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private int id;

    private String name;
    private double price;
    private int rating;

    private List<ReviewDto> reviews = new ArrayList<>();

    // Product
    // @JsonBackRefrence

}
