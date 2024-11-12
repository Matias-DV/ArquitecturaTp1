package microusuariocuenta.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double saldo;
    private Date fechaAlta;
    private int idMercadoPago;
    @ManyToMany(mappedBy = "cuentas")
    private List<Usuario> usuarios;
}
