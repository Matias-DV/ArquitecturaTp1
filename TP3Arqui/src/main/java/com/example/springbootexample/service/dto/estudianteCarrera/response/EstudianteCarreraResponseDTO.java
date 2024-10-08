package com.example.springbootexample.service.dto.estudianteCarrera.response;

import com.example.springbootexample.domain.Carrera;
import com.example.springbootexample.domain.Estudiante;
import com.example.springbootexample.domain.EstudianteCarrera;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class EstudianteCarreraResponseDTO{
    private final Estudiante estudiante;
    private final Carrera carrera;

    private final int antiguedad;

    private final boolean esGraduado;
    private final int fechaInscripcion;

    private final int fechaEgreso;


    public EstudianteCarreraResponseDTO(EstudianteCarrera estudianteCarrera) {
        this.estudiante = estudianteCarrera.getEstudiante();
        this.carrera = estudianteCarrera.getCarrera();
        this.antiguedad = estudianteCarrera.getAntiguedad();
        this.esGraduado = estudianteCarrera.getEsGraduado();
        this.fechaInscripcion = estudianteCarrera.getFechaInscripcion();
        this.fechaEgreso = estudianteCarrera.getFechaEgreso();
    }
}