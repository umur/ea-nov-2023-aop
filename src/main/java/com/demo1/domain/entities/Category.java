package com.demo1.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
