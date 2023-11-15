package com.example.lab4.Aspect;

import com.example.lab4.Model.ActivityLog;
import com.example.lab4.Repository.ActivityLogRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@RequiredArgsConstructor
@Component
public class ExecutionTimeAspect {
    private final ActivityLogRepo activityLogRepo;

    @Around("@annotation(com.example.lab4.Aspect.ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
Object result=joinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ExecutionTime annotation = method.getAnnotation(ExecutionTime.class);

        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(new Date());
        activityLog.setOperation(method.getName());
        activityLog.setDuration(duration);
        activityLogRepo.save(activityLog);

        return result;
}
}