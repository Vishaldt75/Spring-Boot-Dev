package com.spring.aopspringboot.aspect;

import com.spring.aopspringboot.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingDemoAspect {

    @Around("execution(* com.spring.aopspringboot.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint)throws Throwable
    {
        String method =proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n\nExecuting @Around on Method : "+method);

        long begin =System.currentTimeMillis();
        Object result=null;
        try {
           result= proceedingJoinPoint.proceed();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
           // result="Major Accident! but no Worries.";
            throw e;
        }


        long end=System.currentTimeMillis();

        long duration=end-begin;

        System.out.println("==> Duration : "+duration/1000.0+" seconds");

        return result;
    }
    @After("execution(* com.spring.aopspringboot.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint)
    {
        String method =joinPoint.getSignature().toShortString();
        System.out.println("\n\nExecuting @After Finally on Method : "+method);

    }

    @AfterThrowing(pointcut = "execution(* com.spring.aopspringboot.DAO.AccountDAO.findAccounts(..))",
            throwing = "theException")
    public void afterThrowingAdvice(JoinPoint joinPoint,Throwable theException)
    {
        String method =joinPoint.getSignature().toShortString();
        System.out.println("\n\nExecuting @AfterThrowing on Method : "+method);
        System.out.println("--> Exception is : "+theException);
    }

    //After Returning Find account
    @AfterReturning(pointcut = "execution(* com.spring.aopspringboot.DAO.AccountDAO.findAccounts(..))",
            returning = "results")
    public void afterReturningAdvice(JoinPoint joinPoint, List<Account> results)
    {
        String method =joinPoint.getSignature().toShortString();
        System.out.println("\n\nExecuting @AfterReturning on Method : "+method);
        System.out.println("--> Result is : "+results);

        convertAccountToUpper(results);
        System.out.println("--> Result is : "+results);

    }

    private void convertAccountToUpper(List<Account> results) {

        for (Account tempAccount:results)
        {
            String theUpperName=tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }

    // @Before("execution(* com.spring.aopspringboot.DAO.*.*(..))")
    @Before("com.spring.aopspringboot.aspect.AopExpressions.noGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint)
    {
        System.out.println("--> Executing @Before Advice");

        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        System.out.println("Method : "+methodSignature);

        //Display Argumentes
        Object[] args=joinPoint.getArgs();

        for(Object tempArg:args)
        {
            System.out.println(tempArg);
            if(tempArg instanceof Account)
            {
                Account account=(Account) tempArg;
                System.out.println("Account Name : "+account.getName());
                System.out.println("Account Name : "+account.getLevel());
            }
        }
    }
}
