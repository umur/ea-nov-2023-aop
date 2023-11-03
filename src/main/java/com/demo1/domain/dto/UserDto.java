package com.demo1.domain.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
}
