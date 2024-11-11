package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Usuario {
    @Id
    @Getter
    @Column(name="idUsuario")
    private int id;
    @Getter
    private String nombre;
    @Getter
    @Column(unique = true)
    private String nombreUsuario;
    @Getter
    private String apellido;
    @Getter
    @Column(unique = true)
    private String email;
    @Getter
    private String telefono;

    public Usuario(int id, String nombre, String nombreUsuario, String apellido, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public Usuario() {

    }
}
