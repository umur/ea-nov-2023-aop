package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ActivityLogDto {
    private Long id;

    private LocalDateTime date;
    private String operation;
    private Long duration;
}
