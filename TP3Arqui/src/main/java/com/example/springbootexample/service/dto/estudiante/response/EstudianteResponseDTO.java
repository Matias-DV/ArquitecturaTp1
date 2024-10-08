package com.example.springbootexample.service.dto.estudiante.response;

import com.example.springbootexample.domain.Estudiante;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EstudianteResponseDTO {

    private final int dni;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String genero;
    private final String ciudad;
    private final int legajo;

    public EstudianteResponseDTO(Estudiante estudiante ) {
        this.dni = estudiante.getDni();
        this.nombre = estudiante.getNombre();
        this.apellido = estudiante.getApellido();
        this.edad = estudiante.getEdad();
        this.genero = estudiante.getGenero();
        this.ciudad = estudiante.getCiudad();
        this.legajo = estudiante.getLegajo();
    }
}
