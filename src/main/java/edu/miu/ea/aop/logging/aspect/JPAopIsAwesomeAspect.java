package edu.miu.ea.aop.logging.aspect;

import edu.miu.ea.aop.exceptions.JPAopIsAwesomeHeaderException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Order(1)
public class JPAopIsAwesomeAspect {

    @Pointcut("execution(* edu.miu.ea.aop.service..*(..))")
    public void serviceAction() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postAction() {
    }

    @Before(" serviceAction() && postAction()")
    public void checkHeader() {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String headerValue = request.getHeader("AOP-IS-AWESOME");

        if (headerValue == null || headerValue.isEmpty()) {
            throw new JPAopIsAwesomeHeaderException("The POST request lacks a header [AOP-IS-AWESOME].");
        }

    }

}
