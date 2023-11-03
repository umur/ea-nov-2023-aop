package com.demo1.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    private int id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToOne
    @JoinColumn(name="id_address")
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}


