package com.zuul.gateway.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 15:52
 **/
@Log
@Aspect
public class WebLogAspectTest extends WebLogAspectAdapter {

    @Pointcut("execution(public * com.zuul.gateway..*.*(..))")
    public void webLog() {
    }

    @Override
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        super.doBefore(joinPoint);
    }

    @Override
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        super.doAfterReturning(ret);
    }

}
