package com.example.lab3.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private  String zip;
    private  String city;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
