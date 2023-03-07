package com.harshitprajapati.harshitproject;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoginService {

    private Logger logger = Logger.getLogger(LoginService.class.getName());

    public void login(Login login) {
        logger.info("Login Method:-\nUsername = " + login.getUsername() + "\nPassword = " + login.getPassword());
    }
}
