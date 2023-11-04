package com.example.demo.service.impl;

import com.example.demo.dto.ActivityLogDto;
import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final ActivityLogRepository activityLogRepository;
    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepository.save(activityLog);
    }
}
