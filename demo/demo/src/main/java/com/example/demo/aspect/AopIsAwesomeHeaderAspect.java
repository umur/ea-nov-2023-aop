package com.example.demo.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopIsAwesomeHeaderAspect {

    @Before("execution(* edu.miu.service..*(..)) && args(.., request)")
    public void checkAopIsAwesomeHeader(JoinPoint joinPoint, HttpServletRequest request) throws AopIsAwesomeHeaderException {
        if (request.getMethod().equals("POST")) {
            String headerValue = request.getHeader("AOP-IS-AWESOME");
            if (headerValue == null || !headerValue.equals("true")) {
                throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing or invalid.");
            }
        }
    }
}
