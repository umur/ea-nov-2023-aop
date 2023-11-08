package com.miu.edu.student.bacha.lab3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class ActivityLog {
    @Id
    private Long id;
    private LocalDateTime date;
    private String operation;
    private int duration;
}
