package com.example.lab4.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class SimpleUserDTO {
    @Id
    private int id;
    private String firstName;
    private String lastName;
}
