package com.demo1.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

    @Id
    private int id;
    private String street;
    private long zip;
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;
};
