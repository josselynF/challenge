package com.reto.prueba.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    LocalDateTime operationDate;
    Data data[];

    public User(LocalDateTime fecha, Data[] data) {
        this.operationDate = fecha;
        this.data = data;
    }

    public User(Data[] data) {
        this.operationDate = LocalDateTime.now();
        this.data = data;
    }

    public User() {
        this.operationDate = LocalDateTime.now();
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
