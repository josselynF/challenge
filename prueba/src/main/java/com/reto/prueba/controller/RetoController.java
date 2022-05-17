package com.reto.prueba.controller;

import com.reto.prueba.model.User;

import com.reto.prueba.service.RetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetoController {

//    private final RestTemplate restTemplateServicio;
//    private static final String url = "https://reqres.in/api/users";
//
//    public RetoController(RestTemplate restTemplateServicio) {
//        this.restTemplateServicio = restTemplateServicio;
//    }
//
//    @PostMapping("/api/users")
//    public ResponseEntity<User> convertir(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("user-agent", "Application");
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        return ResponseEntity.ok(restTemplateServicio.exchange(url, HttpMethod.GET, entity, User.class).getBody());
//    }
    private final RetoService retoService;

    public RetoController(RetoService retoService) {
        this.retoService = retoService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<User> convertir(){
        return ResponseEntity.ok(retoService.convertir());
    }
}
