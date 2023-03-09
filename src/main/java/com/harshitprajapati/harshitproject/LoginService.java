package com.harshitprajapati.harshitproject;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoginService {

    private Logger logger = Logger.getLogger(LoginService.class.getName());

    public void login(UserLogin userLogin) {
        logger.info("Login Method:-\nUsername = " + userLogin.getUsername() + "\nPassword = " + userLogin.getPassword());
    }
}
