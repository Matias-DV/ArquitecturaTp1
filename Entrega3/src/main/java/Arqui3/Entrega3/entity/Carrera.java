package Arqui3.Entrega3.entity;

import jakarta.persistence.*;

@Entity
public class Carrera {

    @Id
    @Column(name="ID_Carrera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String Nombre;

    public Carrera() {

    }

    public Carrera( String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getId() {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser null.");
        }
        long longId = id; // Convierte Long a long
        if (longId < Integer.MIN_VALUE || longId > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("El valor de id está fuera del rango de un int.");
        }
        return (int) longId; // Convierte long a int
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }
}
