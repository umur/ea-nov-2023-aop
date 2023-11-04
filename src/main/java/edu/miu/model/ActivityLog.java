package edu.miu.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "activity_log")
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String operation;

    private double duration;

    public ActivityLog(LocalDateTime date, String operation, double duration) {
        this.date = date;
        this.operation = operation;
        this.duration = duration;
    }
}
