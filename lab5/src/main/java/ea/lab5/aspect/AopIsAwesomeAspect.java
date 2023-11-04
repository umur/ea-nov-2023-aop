package ea.lab5.aspect;

import ea.lab5.service.AopIsAwesomeHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order(1)
public class AopIsAwesomeAspect {

    @Before("within(ea.lab5.service..*) && execution(@org.springframework.web.bind.annotation.PostMapping * *(..))")
    public void checkHeader() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String headerValue = request.getHeader("AOP-IS-AWESOME");
        if (headerValue == null || headerValue.isEmpty()) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing in the POST request.");
        }
    }
}
