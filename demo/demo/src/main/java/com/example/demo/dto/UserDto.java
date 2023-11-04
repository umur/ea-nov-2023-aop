package com.example.demo.dto;

import com.example.demo.entity.Address;
import com.example.demo.entity.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private Address address;

    private List<Review> reviews;
}
