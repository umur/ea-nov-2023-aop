package edu.miu.ea.aop.model.dto;

import lombok.Data;

@Data
public class JPUserBasicDTO extends JPDtoModel {

    private String email;
    private String firstname;
    private String  lastname;

}
