package com.assginments.lab.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {

    private int id;

    private String name;

    List<ProductDto> products = new ArrayList<>();

    // @JsonManagedReference
    // List<ReviewDTO> reviews;
}
