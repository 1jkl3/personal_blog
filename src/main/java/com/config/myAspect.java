package com.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class myAspect {
    @Pointcut("execution(* )")
    public void point(){

    }


}
