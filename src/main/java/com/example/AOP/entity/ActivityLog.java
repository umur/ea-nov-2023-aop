package com.example.AOP.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String operation;
    private int duration;

    public ActivityLog(LocalDate date, String operation, int duration) {
        this.date = date;
        this.operation = operation;
        this.duration = duration;
    }

    public ActivityLog() {

    }
}
