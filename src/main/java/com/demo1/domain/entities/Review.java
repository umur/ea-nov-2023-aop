package com.demo1.domain.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {

    @Id
    private int id;

    private String comment;

     @ManyToOne
     private Product product;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

}
