package ea.lab5.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private LocalDateTime date;
private String operation;
private long duration;
}
