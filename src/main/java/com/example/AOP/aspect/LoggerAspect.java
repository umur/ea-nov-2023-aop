package com.example.AOP.aspect;

import com.example.AOP.entity.ActivityLog;
import com.example.AOP.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Aspect
@Component
public class LoggerAspect {
    private final HttpServletRequest request;
    private final LogService logService;

    @Around("@annotation(com.example.AOP.aspect.LogMe)")
    public Object log(ProceedingJoinPoint pcp) throws Throwable {
        long begin=System.currentTimeMillis();
        var result= pcp.proceed();
        Thread.sleep(200);
        long end=System.currentTimeMillis();

        String name= pcp.getSignature().getName();

        ActivityLog log=new ActivityLog(LocalDate.now() , name , (int)(end-begin));
        System.out.println(end-begin);
        logService.save(log);

        return result;
    }

}
