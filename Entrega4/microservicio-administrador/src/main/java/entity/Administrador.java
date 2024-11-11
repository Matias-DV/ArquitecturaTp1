package entity;


import jakarta.persistence.*;

@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int precioTarifa;

    private int getPrecioTarifaExtra;

    public Administrador() {
    }
}
