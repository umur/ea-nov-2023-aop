package edu.ea.springaop.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class FullProductDto {

    private Integer id;
    private String name;
    private Double price;
    private Integer rating;
    @JsonBackReference
    private FullCategoryDto category;

    private List<FullReviewDto> reviews;
}
