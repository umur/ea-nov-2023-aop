package edu.ea.springaop.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullReviewDto {

    private Integer id;
    private String comment;
    private UserInfoDto user;
}
