package com.assginments.lab.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private int id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private List<ReviewDto> reviews;

    private AddressDto address;
}
