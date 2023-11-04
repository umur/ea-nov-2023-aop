package ea.lab5.service.impl;

import ea.lab5.entity.ActivityLog;
import ea.lab5.repository.ActivityLogRepository;
import ea.lab5.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository activityLogRepository;

    @Override
    public void saveData(LocalDateTime date, String operation, Long duration) {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(date);
        activityLog.setOperation(operation);
        activityLog.setDuration(duration);
        activityLogRepository.save(activityLog);
    }
}
