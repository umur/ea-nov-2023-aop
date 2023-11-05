package edu.ea.springaop.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;
    private Boolean deleted;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
