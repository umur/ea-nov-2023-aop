package com.miu.edu.student.bacha.lab3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String zip;
    @OneToOne(mappedBy = "address")
    private User customer;
}
