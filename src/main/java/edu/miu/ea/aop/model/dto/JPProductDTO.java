package edu.miu.ea.aop.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;

@Data
public class JPProductDTO extends JPDtoModel {

    private String name;
    private Double price;
    private Long rating;

    @JsonBackReference
    private JPCategoryDTO category;

    private List<JPReviewDTO> reviews;

}
