package entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class UsuarioCuenta {
    @Getter
    @Id
    private int id;

    @Getter
    @ManyToOne
    @JoinColumn(name ="idUsuario", nullable = false)
    private Usuario usuario;

    @Getter
    @ManyToOne
    @JoinColumn(name ="idCuenta", nullable = false)
    private Cuenta cuenta;
}
