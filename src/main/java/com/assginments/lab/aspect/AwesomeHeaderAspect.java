package com.assginments.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class AwesomeHeaderAspect {
    private final HttpServletRequest request;

    @Before("within(com.assginments.lab.service..*)")
    // @Before("execution(* com.assginments.lab.service.*.*(..))")
    public void validateHeader(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        var header = request.getHeader("AOP-IS-AWESOME");
        var method = request.getMethod();
        if (method.equals("POST") && (header == null || header.length() <= 0)) {
            throw new AopIsAwesomeHeaderException("Header Is not Available");
        }

    }
}
