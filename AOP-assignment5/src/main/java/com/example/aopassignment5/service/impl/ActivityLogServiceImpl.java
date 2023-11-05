package com.example.aopassignment5.service.impl;


import com.example.aopassignment5.model.ActivityLog;
import com.example.aopassignment5.repository.ActivityLogRepository;
import com.example.aopassignment5.service.ActivityLogService;
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