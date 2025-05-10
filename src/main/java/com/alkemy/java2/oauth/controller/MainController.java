package com.alkemy.java2.oauth.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {
    @RequestMapping("/")
    public String home() {
        return "Bienvenido A Alkemy Java 2 Clase 4 Oauth2!";
    }

    @GetMapping("/welcome")
    public String welcome(OAuth2AuthenticationToken token)    {
        return "Hola " + token.getPrincipal().getAttributes().get("name") ;
    }
    @RequestMapping("/user")
    public Principal user(Principal user ) {
        return user;
    }

}
