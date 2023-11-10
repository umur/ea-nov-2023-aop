package edu.miu.ea.aop.logging.aspect;

import edu.miu.ea.aop.model.domain.logging.JPActivityLog;
import edu.miu.ea.aop.service.logging.JPActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class JPLoggerAspect {

    private final JPActivityLogService service;

    @Around("@annotation(edu.miu.ea.aop.logging.JPExecutionTime)")
    public void log(ProceedingJoinPoint proceedingJoinPoint) {

        JPActivityLog activityLog = new JPActivityLog();
        activityLog.setOperation(proceedingJoinPoint.getSignature().getName());
        activityLog.setDate(LocalDateTime.now());
        Date startDate = new Date();

        try {
            proceedingJoinPoint.proceed();
            activityLog.setDuration((new Date()).getTime() - startDate.getTime());
            service.add(activityLog);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

}
