package com.assginments.lab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFilterDto {
    private double minPrice;
    private int categoryId;
    private String name;
}
