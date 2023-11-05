package com.example.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.lab3.Entity.Review}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto implements Serializable {
    private int id;
    private String comment;
}