package ea.lab5.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class ActivityLogDto {

private int id;
private LocalDateTime date;
private String operation;
private long duration;
}
