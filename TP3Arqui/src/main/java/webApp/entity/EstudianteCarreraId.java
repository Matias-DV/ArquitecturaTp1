package webApp.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstudianteCarreraId implements Serializable {
    private int dni; // Suponiendo que el DNI es un entero
    private Long idCarrera; // Asegúrate de que el tipo corresponda con tu implementación de Carrera

    // Constructor vacío
    public EstudianteCarreraId() {
    }

    // Constructor que acepta ambos campos
    public EstudianteCarreraId(int dni, Long idCarrera) {
        this.dni = dni;
        this.idCarrera = idCarrera;
    }

    // Getters
    public int getDni() {
        return dni;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }
}