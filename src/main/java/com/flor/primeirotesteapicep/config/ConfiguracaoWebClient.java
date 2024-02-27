package com.flor.primeirotesteapicep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfiguracaoWebClient {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
            .baseUrl("https://viacep.com.br/ws/")
            .build();
    }

}