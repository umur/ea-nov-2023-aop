package com.miu.lab4aop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miu.lab4aop.entity.ActivityLog;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link ActivityLog}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityLogDto implements Serializable {
    private Long id;
    @NotNull
    @PastOrPresent(message = "Date must not be in the future")
    private LocalDate date;
    @NotNull(message = "Operation cannot be null")
    @Size(min = 1)
    @NotEmpty(message = "Operation cannot be empty")
    @NotBlank(message = "Operation cannot be blank")
    private String operation;
    @NotNull(message = "Duration cannot be null")
    @PositiveOrZero(message = "Duration can not be negative")
    private Long durationInMillis;
}