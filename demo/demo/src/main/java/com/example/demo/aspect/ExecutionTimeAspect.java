package com.example.demo.aspect;

import com.example.demo.dto.ActivityLogDto;
import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.service.LogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final LogService logService;
    private final ModelMapper modelMapper;

    @Around("@annotation(com.example.demo.aspect.ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Duration is: " + duration);
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(LocalDateTime.now());
        activityLog.setOperation(joinPoint.getSignature().toShortString());
        activityLog.setDuration(duration);

        logService.save(activityLog);

        return result;
    }
}
