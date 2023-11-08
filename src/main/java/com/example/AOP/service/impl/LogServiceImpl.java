package com.example.AOP.service.impl;

import com.example.AOP.entity.ActivityLog;
import com.example.AOP.repository.LogRepo;
import com.example.AOP.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LogServiceImpl implements LogService {
    private final LogRepo logRepo;
    @Override
    public ActivityLog save(ActivityLog log) {
        logRepo.save(log);
        return log;
    }
}
