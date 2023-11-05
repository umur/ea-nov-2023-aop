package com.example.lab3.service.impl;

import com.example.lab3.Entity.ActiveLog;
import com.example.lab3.repository.ActiveLogRepository;
import com.example.lab3.service.ActiveLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ActiveLogServiceImpl implements ActiveLogService {

    private final ActiveLogRepository activeLogRepository;
    @Override

    public void save(ActiveLog activeLog) {
        activeLogRepository.save(activeLog);


    }

}
