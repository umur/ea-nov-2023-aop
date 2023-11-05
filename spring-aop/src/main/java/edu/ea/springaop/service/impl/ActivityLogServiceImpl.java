package edu.ea.springaop.service.impl;

import edu.ea.springaop.model.ActivityLog;
import edu.ea.springaop.repository.ActivityLogRepository;
import edu.ea.springaop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ActivityLogServiceImpl  implements ActivityLogService {
    private final ActivityLogRepository activityLogRepository;

    @Override
    @Transactional
    public ActivityLog add(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }
}
