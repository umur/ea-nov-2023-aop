package com.assginments.lab.dto;

import com.assginments.lab.dto.Generic.GenericDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto extends GenericDto {
    private int id;

    private String comment;
}
