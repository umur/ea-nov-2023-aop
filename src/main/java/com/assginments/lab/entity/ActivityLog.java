package com.assginments.lab.entity;

import java.time.LocalDateTime;

import com.assginments.lab.entity.Generic.GenericEntity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ActivityLog extends GenericEntity {
    private LocalDateTime date;
    private String operation;
    private Long duration;
}
