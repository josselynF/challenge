package com.reto.prueba.service.Impl;

import com.reto.prueba.model.User;
import com.reto.prueba.service.RetoService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RetoServiceImpl implements RetoService {
    private final RestTemplate restTemplateServicio;
    private static final String url = "https://reqres.in/api/users";

    public RetoServiceImpl(RestTemplate restTemplateServicio) {
        this.restTemplateServicio = restTemplateServicio;
    }

    @Override
    public User convertir() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplateServicio.exchange(url, HttpMethod.GET, entity, User.class).getBody();
    }
}
