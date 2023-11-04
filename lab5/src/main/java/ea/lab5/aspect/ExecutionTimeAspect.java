package ea.lab5.aspect;

import ea.lab5.repository.ActivityLogRepository;
import ea.lab5.service.impl.ActivityLogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {
private final ActivityLogServiceImpl activityLogService;
    @Around("@annotation(ea.lab5.aspect.ExecutionTime)")
    public Object ExecutionTime(ProceedingJoinPoint pcp) throws Throwable {
        long begin = System.currentTimeMillis();
        String operation =pcp.getSignature().getName();
        var result = pcp.proceed();
        long end = System.currentTimeMillis();
        long duration = end-begin;

        activityLogService.saveData(LocalDateTime.now(),operation,duration);
        return result;
    }
}
