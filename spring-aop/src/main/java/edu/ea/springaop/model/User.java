package edu.ea.springaop.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String  password;
    private String  firstName;
    private String  lastname;
    private Boolean deleted;
    @OneToOne
    private Address address;

    @OneToMany (mappedBy = "user",cascade = CascadeType.ALL)
    private List<Review> reviews;
}
