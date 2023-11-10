package edu.miu.ea.aop.model.dto;

import lombok.Data;

@Data
public class JPReviewDTO extends JPDtoModel {

    private String comment;
    private JPUserBasicDTO user;

}
