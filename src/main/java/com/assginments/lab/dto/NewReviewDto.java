package com.assginments.lab.dto;

import com.assginments.lab.dto.Generic.GenericNewDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewReviewDto extends GenericNewDto {
    private int id;
    private String comment;

    private int userId;
    private int productId;
}
