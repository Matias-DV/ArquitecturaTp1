package dto;

import entities.Cuenta;
import entities.Usuario;

public class UsuarioCuentaDTO {
    private int id;
    private Usuario usuario;
    private Cuenta cuenta;

    public UsuarioCuentaDTO(int id, Usuario usuario, Cuenta cuenta) {
        this.id = id;
        this.usuario = usuario;
        this.cuenta = cuenta;
    }
}

