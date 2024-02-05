package com.dinesh.plan.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Aspect
@Component
public class LoggingAspect {
    Log logger = LogFactory.getLog(this.getClass());

    @AfterThrowing(pointcut = "execution(* com.dinesh.plan.*.*.*(..))", throwing = "exception")
    public void afterThrowing(Exception exception) {
        logger.error(exception.getMessage());
    }
}
