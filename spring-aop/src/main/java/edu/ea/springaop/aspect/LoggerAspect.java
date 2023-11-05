package edu.ea.springaop.aspect;

import edu.ea.springaop.model.ActivityLog;
import edu.ea.springaop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAspect {

    private final ActivityLogService activityLogService;

    @Around("@annotation(edu.ea.springaop.aspect.ExecutionTime)")
    public void log(ProceedingJoinPoint jp )
    {

        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(LocalDateTime.now());
        activityLog.setOperation(jp.getSignature().getName());
        Date   startDate =  new Date();
        try {
            jp.proceed();
            activityLog.setDuration((new Date()).getTime() -startDate.getTime());
            activityLogService.add(activityLog);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }


    }
}
