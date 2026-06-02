package com.ptit.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("execution(* com.ptit.service.ItemService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LoggingAspect - @Before] Bắt đầu chạy phương thức: " + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* com.ptit.service.ItemService.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("[LoggingAspect - @AfterReturning] Phương thức: " + joinPoint.getSignature().toShortString() + " trả về thành công với kết quả: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.ptit.service.ItemService.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("[LoggingAspect - @AfterThrowing] Phương thức: " + joinPoint.getSignature().toShortString() + " ném ra ngoại lệ: " + ex.getMessage());
    }

    @After("execution(* com.ptit.service.ItemService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[LoggingAspect - @After] Kết thúc phương thức (finally): " + joinPoint.getSignature().toShortString());
    }
}
