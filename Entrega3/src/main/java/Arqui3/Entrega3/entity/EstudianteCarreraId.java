package Arqui3.Entrega3.entity;

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

    public int getIdCarrera() {
        if (idCarrera == null) {
            throw new IllegalArgumentException("El id no puede ser null.");
        }
        long longId = idCarrera; // Convierte Long a long
        if (longId < Integer.MIN_VALUE || longId > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("El valor de id está fuera del rango de un int.");
        }
        return (int) longId; // Convierte long a int
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudianteCarreraId that = (EstudianteCarreraId) o;
        return Objects.equals(dni, that.dni) && Objects.equals(idCarrera, that.idCarrera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, idCarrera);
    }
}