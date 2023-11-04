package com.example.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("@annotation(com.example.demo.aspect.LogMe)")
    public void log(JoinPoint joinPoint){
        System.out.println("Method is: " + joinPoint.getSignature().getName());
    }
}
