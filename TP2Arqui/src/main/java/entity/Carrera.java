package entity;

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

    public Carrera( String nombre, Long id) {
        this.Nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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
                ", Nombre='" + Nombre + '\'' +
                '}';
    }
}
