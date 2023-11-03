package com.assginments.lab.dto;

import java.time.LocalDateTime;

import com.assginments.lab.dto.Generic.GenericNewDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewActivityLogDto extends GenericNewDto {
    private LocalDateTime date;
    private String operation;
    private Long duration;
}
