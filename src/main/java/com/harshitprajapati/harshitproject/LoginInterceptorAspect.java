package com.harshitprajapati.harshitproject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.util.logging.Logger;

@Aspect
@Component
public class LoginInterceptorAspect {

    private Logger logger = Logger.getLogger(LoginInterceptorAspect.class.getName());

    @Around("execution(* com.harshitprajapati.harshitproject.*.*(..))")
    public Object login(ProceedingJoinPoint joinPoint) throws Throwable {

        final String fileName = "Username.txt";
        Object[] arguments = joinPoint.getArgs();
        String content = String.valueOf(arguments);

        logger.info("Login Interceptor Aspect: Calling the intercepted method");

        try (FileWriter fileWriter = new FileWriter("Username.txt")) {
            fileWriter.write(content);
            fileWriter.flush();
        }

//        try (var writer = new BufferedWriter(new PrintWriter(fileName))) {
//            writer.write(content);
//            writer.newLine();
//            writer.flush();
//        }

        logger.info("Login Interceptor Aspect: Method executed and intercepted username and written to file.");

        return joinPoint.proceed();
    }
}
