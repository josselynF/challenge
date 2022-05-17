package com.reto.prueba.service.Impl;

import com.reto.prueba.model.Data;
import com.reto.prueba.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RetoServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    private static final String url = "https://reqres.in/api/users";

    @InjectMocks
    private RetoServiceImpl retoServiceImpl;

    @Test
    @DisplayName("Fecha no nulo")
    void fechaNoNulo(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<User> u =    ResponseEntity.ok(new User(
                new Data[]{
                        new Data(1, null,"george.bluth@reqres.in", "George", "https://reqres.in/img/faces/1-image.jpg"),
                        new Data(2, null, "janet.weaver@reqres.in", "Janet", "https://reqres.in/img/faces/2-image.jpg"),
                        new Data(3, null,"emma.wong@reqres.in", "Emma", "https://reqres.in/img/faces/3-image.jpg"),
                        new Data(4, null, "eve.holt@reqres.in", "Eve", "https://reqres.in/img/faces/4-image.jpg"),
                        new Data(5, null, "charles.morris@reqres.in", "Charles", "https://reqres.in/img/faces/5-image.jpg"),
                        new Data(6, null, "tracey.ramos@reqres.in", "Tracey", "https://reqres.in/img/faces/6-image.jpg")
                }));
        when(restTemplate.exchange(url, HttpMethod.GET, entity, User.class))
        .thenReturn(u);
        LocalDateTime fecha = retoServiceImpl.convertir().getOperationDate();
        assertNotNull(fecha);
    }


}