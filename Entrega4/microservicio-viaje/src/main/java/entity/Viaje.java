package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idViaje;
    @Column
    private long idUsuario;
    @Column
    private long idMonopatin;
    @Column
    private long idParada;
    @Column
    private Date fechaInicio;
    @Column
    private Date fechaFin;
    @Column
    private float kmRecorridos;
    @Column
    private float costo;


    public Viaje () {

    }

    public Viaje(float costo, float kmRecorridos, Date fechaFin, Date fechaInicio, long idParada, long idMonopatin, long idUsuario) {
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
