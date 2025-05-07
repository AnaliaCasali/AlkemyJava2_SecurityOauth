package com.alkemy.java2.oauth.config;

 import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class OpenAPIConfig {

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("API Ejemplo Java2 Clase 4")
                            .version("1.0.0")
                            .description("Documentación de la API RESTful con OpenAPI y OAuth2")
                            .contact(new Contact()
                                    .name("Soporte Técnico")
                                    .email("acasali.ac@gmail.com")));
        }
    }
