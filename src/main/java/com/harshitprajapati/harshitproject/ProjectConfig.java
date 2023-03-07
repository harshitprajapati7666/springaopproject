package com.harshitprajapati.harshitproject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ProjectConfig {

    public LoginInterceptorAspect loginInterceptorAspect() {
        return new LoginInterceptorAspect();
    }
}
