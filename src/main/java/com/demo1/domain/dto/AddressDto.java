package com.demo1.domain.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private int id;

    private String street;
    private String zip;
    private String city;

}
