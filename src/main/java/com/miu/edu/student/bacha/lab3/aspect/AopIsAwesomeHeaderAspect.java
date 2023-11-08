package com.miu.edu.student.bacha.lab3.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AopIsAwesomeHeaderAspect {

    @Before("execution(* com.miu.edu.student.bacha.lab3.services..*(..)) && @within(org.springframework.stereotype.Service)")
    public void checkHeader(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String headerValue = request.getHeader("AOP-IS-AWESOME");

        if (headerValue == null || !headerValue.equals("true")) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing or invalid");
        }
    }
}

