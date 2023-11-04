package com.example.demo.dto;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class AddressDto {
    private Long id;
    private String street;
    private String zip;
    private String city;

    private User user;
}
