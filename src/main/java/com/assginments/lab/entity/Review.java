package com.assginments.lab.entity;

import com.assginments.lab.entity.Generic.GenericEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review extends GenericEntity {

    private String comment;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;
}
