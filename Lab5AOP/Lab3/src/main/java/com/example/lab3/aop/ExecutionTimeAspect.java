package com.example.lab3.aop;

import com.example.lab3.Entity.ActiveLog;
import com.example.lab3.service.ActiveLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActiveLogService activeLogService;
    private final ModelMapper modelMapper;

    @Around(value = "@annotation(com.example.demo.aspect.ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Duration is: " + duration);
        ActiveLog activeLog = new ActiveLog();
        activeLog.setDate(LocalDateTime.now());
        activeLog.setOperation(joinPoint.getSignature().toShortString());
        activeLog.setDuration(duration);

        ActiveLogService.save(activeLog);

        return result;
    }
}
