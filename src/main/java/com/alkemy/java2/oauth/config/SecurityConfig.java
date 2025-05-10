package com.alkemy.java2.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(
            registry -> {
              registry.requestMatchers("/", "/login","/swagger-ui.html", "/swagger-ui/index.html").permitAll();
              registry.anyRequest().authenticated();
            })
        .oauth2Login(
            oauth2login ->
                oauth2login
            //        .loginPage("/login")
                    .successHandler((request, response, authentication) -> {
                      response.sendRedirect("/profile");
                    }))
                .formLogin(Customizer.withDefaults())
        .logout(logout -> logout
            .logoutSuccessUrl("/") // Redirige al usuario después de cerrar sesión
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID"))
        .build();
  }


}
