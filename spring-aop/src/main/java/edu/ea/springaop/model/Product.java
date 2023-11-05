package edu.ea.springaop.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Integer rating;
    private Boolean deleted;
    @ManyToOne
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Review> reviews;
}
