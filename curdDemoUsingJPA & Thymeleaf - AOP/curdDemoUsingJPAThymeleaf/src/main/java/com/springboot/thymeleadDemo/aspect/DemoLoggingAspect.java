package com.springboot.thymeleadDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    //setup logger

    private Logger logger=Logger.getLogger(getClass().getName());
    @Pointcut("execution(* com.springboot.thymeleadDemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.springboot.thymeleadDemo.service.*.*(..))")
    private void forServicePackage() {}
    @Pointcut("execution(* com.springboot.thymeleadDemo.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint)
    {
        String theMethod=joinPoint.getSignature().toShortString();
        logger.info("--> in @Before : Calling Method : "+theMethod);

        Object[] args=joinPoint.getArgs();

        for (Object tempArg:args)
        {
            logger.info("==> Arguments : "+tempArg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint joinPoint,Object theResult)
    {
        String theMethod=joinPoint.getSignature().toShortString();
        logger.info("***> in @AfterReturning : Calling Method : "+theMethod);
        logger.info("===> Result : "+theResult);
    }
}
