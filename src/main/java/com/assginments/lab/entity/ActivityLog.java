package com.assginments.lab.entity;

import java.time.LocalDateTime;

import com.assginments.lab.entity.Generic.GenericEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "activityLogs")
@Getter
@Setter
public class ActivityLog extends GenericEntity {
    private LocalDateTime date;
    private String operation;
    private Long duration;
}
