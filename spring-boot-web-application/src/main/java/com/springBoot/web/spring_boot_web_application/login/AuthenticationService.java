package com.springBoot.web.spring_boot_web_application.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String name, String password){
        boolean isValidUser = name.equalsIgnoreCase("pratik");
        boolean isValidPassword = password.equalsIgnoreCase("admin");

        return isValidUser && isValidPassword;

    }
}
