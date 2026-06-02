package com.ptit.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class PerformanceAspect {

    @Around("execution(* com.ptot.service.ItemService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("[PerformanceAspect - @Around] Bắt đầu đo thời gian chạy của: " + pjp.getSignature().toShortString());
        try {
            return pjp.proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;
            System.out.println("[PerformanceAspect - @Around] Kết thúc đo thời gian chạy của: " + pjp.getSignature().toShortString() + " - Thời gian chạy: " + duration + " ms");
        }
    }
}
