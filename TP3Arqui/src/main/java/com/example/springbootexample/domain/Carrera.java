package com.example.springbootexample.domain;

import com.example.springbootexample.service.dto.carrera.request.CarreraRequestDTO;
import com.example.springbootexample.service.dto.estudiante.request.EstudianteRequestDTO;
import jakarta.persistence.*;

@Entity
public class Carrera {

    @Id
    @Column(name="ID_Carrera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;

    public Carrera(CarreraRequestDTO request) {

    }

    public Carrera( String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }

    public Carrera(EstudianteRequestDTO request) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", Nombre='" + nombre + '\'' +
                '}';
    }
}