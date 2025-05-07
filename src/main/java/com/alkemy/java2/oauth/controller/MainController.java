package com.alkemy.java2.oauth.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    @RequestMapping("/")
    public String home() {
        return "Bienvenido A Alkemy Java 2 Clase 4 Oauth2!";
    }
    @RequestMapping("/user")
    public Principal user(Principal user ) {
        return user;
    }

}
