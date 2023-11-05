package com.miu.lab4aop.service;

import com.miu.lab4aop.dto.ActivityLogDto;
import com.miu.lab4aop.entity.ActivityLog;

import java.util.List;

public interface ActivityLogService {
    ActivityLogDto createActivityLog(ActivityLogDto activityLog);
    ActivityLogDto updateActivityLog(ActivityLogDto activityLog, Long id);
    ActivityLogDto findById(Long id);
    void deleteById(Long id);
    List<ActivityLogDto> findAll();
}
