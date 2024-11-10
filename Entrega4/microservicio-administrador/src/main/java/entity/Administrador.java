package entity;


import jakarta.persistence.*;

@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int precioTarifa;
    @Column
    private int getPrecioTarifaExtra;

    public Administrador() {
    }
}
