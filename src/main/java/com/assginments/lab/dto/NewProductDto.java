package com.assginments.lab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewProductDto {

    private int id;
    private String name;
    private double price;
    private int rating;

    private int categoryId;
}
