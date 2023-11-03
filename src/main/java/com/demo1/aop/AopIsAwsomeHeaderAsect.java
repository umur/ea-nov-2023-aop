package com.demo1.aop;

import com.demo1.exception.AopIsAwesomeHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopIsAwsomeHeaderAsect {

    @Before("execution(* com.demo1..service..*(..)) && args(.., request)")
    public void checkAopIsAwesomeHeader(JoinPoint joinPoint, HttpServletRequest request) {
        if (request.getMethod().equals("POST")) {
            String headerValue = request.getHeader("AOP-IS-AWESOME");
            if (headerValue == null || !headerValue.equals("true")) {
                throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing or not set to 'true'");
            }
        }
    }
}
