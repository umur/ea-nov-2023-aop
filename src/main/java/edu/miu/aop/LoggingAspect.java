package edu.miu.aop;

import edu.miu.exception.AopIsAwesomeHeaderException;
import edu.miu.model.ActivityLog;
import edu.miu.repository.ActivityLogRepo;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {
    private final ActivityLogRepo activityLogRepo;
    private final HttpServletRequest servletRequest;

    @Around("@annotation(edu.miu.aop.ExecutionTime)")
    public Object executionTimeCalculator(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String operation = joinPoint.getSignature().getName();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long takenTime = endTime - startTime;
        activityLogRepo.save(
                new ActivityLog(LocalDateTime.now(), operation,  takenTime));
        return result;
    }
    @Around("within(edu.miu.service.impl..*)")
    public Object headerCheck(ProceedingJoinPoint joinPoint) throws Throwable{
        if(servletRequest.getHeader("AOP-IS-AWESOME") == null){
            throw new AopIsAwesomeHeaderException();
        }
        return joinPoint.proceed();
    }
}
