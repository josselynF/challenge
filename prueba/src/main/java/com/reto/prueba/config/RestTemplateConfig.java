package com.reto.prueba.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Value("${service.api}")
    public String service_api;

    @Bean
    public RestTemplate restTemplateServicio(){
        return new RestTemplateBuilder().rootUri(service_api).build();
    }
}
