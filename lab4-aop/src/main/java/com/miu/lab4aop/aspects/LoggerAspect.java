package com.miu.lab4aop.aspects;

import com.miu.lab4aop.dto.ActivityLogDto;
import com.miu.lab4aop.exceptions.AopIsAwesomeHeaderException;
import com.miu.lab4aop.service.ActivityLogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;

@RequiredArgsConstructor
@Aspect
@Component
public class LoggerAspect {
    private final HttpServletRequest request;
    private final ActivityLogService activityLogService;

    @Around("@annotation(com.miu.lab4aop.aspects.annotations.ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        activityLogService.createActivityLog(ActivityLogDto.builder().date(LocalDate.now())
                .operation(joinPoint.getSignature().getName()).durationInMillis(executionTime).build());
        return result;
    }

    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object checkHeader(ProceedingJoinPoint pjp) throws Throwable {
        String header = request.getHeader("AOP-IS-AWESOME");
        System.out.println("AOP-IS-AWESOME: " + header);
        if (header == null) {
            throw new AopIsAwesomeHeaderException("The AOP-IS-AWESOME header is required for POST requests.");
        }
        return pjp.proceed();
    }
}
