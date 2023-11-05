package com.example.lab4.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
class SimpleProductDTO {
    @Id
    private int id;
    private String name;
    private double price;
    private double rating;
}
