package com.harshitprajapati.harshitproject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Logger;

@Aspect
@Component
public class LoginInterceptorAspect {

    private Logger logger = Logger.getLogger(LoginInterceptorAspect.class.getName());

    @Around("execution(* com.harshitprajapati.harshitproject.*.login(..)) && args(userLogin,..)")
    public Object login(ProceedingJoinPoint joinPoint, UserLogin userLogin) throws Throwable {

        final String fileName = "Username.txt";
        String content = userLogin.getUsername();
        logger.info("Login Interceptor Aspect: Calling the intercepted method");

        try (var fileWriter = new BufferedWriter(new FileWriter(fileName))) {
            fileWriter.write(content);
            fileWriter.flush();
        }

        logger.info("Login Interceptor Aspect: Method executed and intercepted username and written to file.");

        return joinPoint.proceed();
    }
}
