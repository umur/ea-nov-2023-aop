package com.assginments.lab.dto;

import java.time.LocalDateTime;

import com.assginments.lab.dto.Generic.GenericDto;

public class ActivityLogDto extends GenericDto {
    private LocalDateTime date;
    private String operation;
    private Long duration;
}
