package com.assginments.lab.dto;

import java.time.LocalDateTime;

import com.assginments.lab.dto.Generic.GenericNewDto;

public class NewActivityLogDto extends GenericNewDto {
    private LocalDateTime date;
    private String operation;
    private Long duration;
}
