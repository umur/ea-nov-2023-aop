package ea.lab5.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ActivityLogService {
    void saveData(LocalDateTime date , String Operation, Long duration);

}
