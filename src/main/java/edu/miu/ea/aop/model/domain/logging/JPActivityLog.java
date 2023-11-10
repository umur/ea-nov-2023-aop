package edu.miu.ea.aop.model.domain.logging;

import edu.miu.ea.aop.model.domain.JPBaseEntityWithIdAuto;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
public class JPActivityLog extends JPBaseEntityWithIdAuto {

    private String operation;
    private Long duration;
    private LocalDateTime date;

}
