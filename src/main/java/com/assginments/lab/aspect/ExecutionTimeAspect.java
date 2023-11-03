package com.assginments.lab.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.assginments.lab.dto.NewActivityLogDto;
import com.assginments.lab.service.Interfaces.ActivityLogService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {
    private final HttpServletRequest request;
    private final ActivityLogService activityLogService;

    @Around("@annotation(com.assginments.lab.aspect.Calculate)")
    public Object calculate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long begin = System.currentTimeMillis();
        var result = proceedingJoinPoint.proceed();
        Long end = System.currentTimeMillis();

        NewActivityLogDto alog = new NewActivityLogDto();
        alog.setDate(LocalDateTime.now());
        alog.setDuration(end - begin);
        alog.setOperation(request.getMethod());
        activityLogService.add(alog);

        return result;

    }
}
