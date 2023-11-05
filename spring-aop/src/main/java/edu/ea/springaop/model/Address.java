package edu.ea.springaop.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private Integer zip;
    private String city;
    private Boolean deleted;
    @OneToOne(mappedBy = "address")
    private User user;


}
