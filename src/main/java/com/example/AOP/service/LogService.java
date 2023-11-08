package com.example.AOP.service;

import com.example.AOP.entity.ActivityLog;
import com.mysql.cj.log.Log;

public interface LogService {

    public ActivityLog save(ActivityLog log);
}
