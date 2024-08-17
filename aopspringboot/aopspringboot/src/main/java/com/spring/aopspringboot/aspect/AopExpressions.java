package com.spring.aopspringboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect

public class AopExpressions {
    @Pointcut("execution(* com.spring.aopspringboot.DAO.*.*(..))")
    public void forDaoPackage() {}

    //pointcut for Getter and setter.
    @Pointcut("execution(* com.spring.aopspringboot.DAO.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.spring.aopspringboot.DAO.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void noGetterSetter(){}
}
