package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Date;

@Entity
public class Cuenta {
    @Getter
    @Id
    @Column(name="idCuenta")
    private int id;
    @Getter
    private double saldo;
    @Getter
    private Date fechaAlta;
    @Getter
    private int idMercadoPago;

    public Cuenta(int id, double saldo, Date fechaAlta, int idMercadoPago) {
        this.id = id;
        this.saldo = saldo;
        this.fechaAlta = fechaAlta;
        this.idMercadoPago = idMercadoPago;
    }

    public Cuenta() {

    }
}
