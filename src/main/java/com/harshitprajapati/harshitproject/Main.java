package com.harshitprajapati.harshitproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = c.getBean(LoginService.class);

        Login login = new Login();
        login.setUsername("Harshit");
        login.setPassword("Prajapati");

        service.login(login);
    }
}
