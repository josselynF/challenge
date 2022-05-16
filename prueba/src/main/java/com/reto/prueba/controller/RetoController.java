package com.reto.prueba.controller;

import com.reto.prueba.model.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetoController {

    private final RestTemplate restTemplateServicio;
    private static final String url = "https://reqres.in/api/users";

    public RetoController(RestTemplate restTemplateServicio) {
        this.restTemplateServicio = restTemplateServicio;
    }

    @PostMapping("/api/users")
    public ResponseEntity<Object> convertir(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return ResponseEntity.ok(restTemplateServicio.exchange(url, HttpMethod.GET, entity, User.class).getBody());
    }
}
