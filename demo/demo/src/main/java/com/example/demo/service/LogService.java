package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
    public void save(ActivityLog activityLog);
}
