package com.harshitprajapati.harshitproject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

@Aspect
@Component
public class LoginInterceptorAspect {

    private Logger logger = Logger.getLogger(LoginInterceptorAspect.class.getName());

    @Around("execution(* com.harshitprajapati.harshitproject.*.*(..))")
    public void login(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        logger.info("Login Interceptor Aspect: Calling the intercepted method");

        String newArguments = String.valueOf(arguments);

        try (FileWriter fileWriter = new FileWriter("Username.txt")) {
            fileWriter.write(newArguments);
        } catch (IOException e) {
            e.printStackTrace();
        }

        joinPoint.proceed();
        logger.info("Login Interceptor Aspect: Method executed and intercepted username and written to file.");
    }
}
