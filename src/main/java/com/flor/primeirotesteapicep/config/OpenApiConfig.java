package com.flor.primeirotesteapicep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("API para buscar CEP e calcular frete com java 17 e Spring Boot 3.2.3.")
                .version("v1")
                .description("Basta informar um CEP com ou sem hífen que a API informará os dados do endereço mais o frete.")
                .termsOfService("www.linkedin.com/in/luan-flor-2287b2262")
                .license(
                    new License()
                        .name("Apache 2.0")
                        .url("https://maven.apache.org/")));
    }
}
