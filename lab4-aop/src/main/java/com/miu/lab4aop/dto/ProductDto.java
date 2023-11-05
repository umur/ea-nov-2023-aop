package com.miu.lab4aop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DTO for {@link com.miu.lab4aop.entity.Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private Double rating;
    private CategoryDto category;
    private Set<ReviewDto> reviews = new LinkedHashSet<>();
}