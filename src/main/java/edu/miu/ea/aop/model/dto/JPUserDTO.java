package edu.miu.ea.aop.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class JPUserDTO extends JPDtoModel {

    private String email;
    private String firstname;
    private String lastname;
    private String password;

    private JPAddressDTO address;
    private List<JPReviewDTO> reviews;

}
