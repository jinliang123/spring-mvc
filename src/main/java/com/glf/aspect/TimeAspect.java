package com.glf.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * description
 *
 * @author jinliang 2019/05/08 14:55
 */
@Aspect
@Component
public class TimeAspect {
    Logger logger = LoggerFactory.getLogger(TimeAspect.class);

    @Around("execution(* com.glf.controller.UserController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("time aspect start");
        Object[] args = pjp.getArgs();
        for(Object arg :args){
            logger.info("arg is "+arg);
        }
        long start = new Date().getTime();
        Object proceed = pjp.proceed();
        long end = new Date().getTime();
        logger.info("aspect used time:"+(end-start));
        logger.info("time aspect end");
        return proceed;
    }
}
