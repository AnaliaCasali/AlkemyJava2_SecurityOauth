package com.alkemy.java2.oauth.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
public class ViewController {

    @Operation(summary = "Obtiene un profile de usuario"
            , description = "Devuelve los detalles de un usuario específico")
    @GetMapping("/profile")
    public String profile(OAuth2AuthenticationToken token, Model model)
    {
        model.addAttribute("name", token.getPrincipal().getAttribute("name"));
        model.addAttribute("email", token.getPrincipal().getAttribute("email"));
        model.addAttribute("photo", token.getPrincipal().getAttribute("picture"));
        return "user-profile";
    }

    @GetMapping("/login")
    public String login(OAuth2AuthenticationToken token, Model model){
        return "custom_login";
    }
}
