package com.miu.lab4aop.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Fetch(value = FetchMode.JOIN)
    @OneToMany(mappedBy = "category", orphanRemoval = true,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Product> products = new LinkedHashSet<>();

}
