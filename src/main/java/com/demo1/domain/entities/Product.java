package com.demo1.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Product {

    @Id
    private int id;
    private String name;
    private double price;
    private int rating;


    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

}
