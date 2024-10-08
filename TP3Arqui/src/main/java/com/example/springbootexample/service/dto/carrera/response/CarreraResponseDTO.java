package com.example.springbootexample.service.dto.carrera.response;

import com.example.springbootexample.domain.Carrera;

public class CarreraResponseDTO {
    private final Long id;
    private final String nombre;

    public CarreraResponseDTO(Carrera carrera) {
        this.id = carrera.getId();
        this.nombre = carrera.getNombre();
    }

    public CarreraResponseDTO(Long id, String nombre) {
    }
}
