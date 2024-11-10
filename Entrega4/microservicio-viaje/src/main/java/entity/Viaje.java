package entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idViaje;
    private int idUsuario;
    private int idMonopatin;
    private int idParada;
    private Date fechaInicio;
    private Date fechaFin;
    private float kmRecorridos;
    private float costo;

    public Viaje () {

    }

    public Viaje(float costo, float kmRecorridos, Date fechaFin, Date fechaInicio, int idParada, int idMonopatin, int idUsuario, int idViaje) {
        this.costo = costo;
        this.kmRecorridos = kmRecorridos;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.idParada = idParada;
        this.idMonopatin = idMonopatin;
        this.idUsuario = idUsuario;
        this.idViaje = idViaje;
    }
}
