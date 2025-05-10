package com.alkemy.java2.oauth.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class OpenApiConfig implements WebMvcConfigurer {

  private static final String SWAGGER_UI_PATH = "/swagger-ui.html";
  private static final String API_TITLE = "API Ejemplo Java2 Clase 4";
  private static final String API_VERSION = "1.0.0";
  private static final String API_DESCRIPTION = "Documentación de la API RESTful con OpenAPI y OAuth2 ";
  private static final String AUTHMESSAGE = "Bearer Authentication ";
  private static final String CONTACT_NAME = "Analía ";
  private static final String CONTACT_EMAIL = "mail@mail.com";

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addRedirectViewController("/", SWAGGER_UI_PATH);
    registry.addRedirectViewController("/swagger-ui", SWAGGER_UI_PATH);
    registry.addViewController("/swagger-ui/").setViewName("forward:/swagger-ui/index.html");
  }

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title(API_TITLE)
            .version(API_VERSION)
            .description(API_DESCRIPTION).contact(new Contact()
                .name(CONTACT_NAME)
                .email(CONTACT_EMAIL)))
        .addSecurityItem(new SecurityRequirement()
            .addList(AUTHMESSAGE))
        .components(new Components()
            .addSecuritySchemes(AUTHMESSAGE,
                new SecurityScheme()
                    .name(AUTHMESSAGE)
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")));
  }
}