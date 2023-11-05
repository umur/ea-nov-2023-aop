package edu.ea.springaop.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullCategoryDto {

    private Integer id;
    private String name;
    @JsonManagedReference
    private List<FullProductDto> products;

}
