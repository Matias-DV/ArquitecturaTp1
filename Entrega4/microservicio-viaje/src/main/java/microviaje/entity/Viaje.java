package microviaje.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idViaje;
    private int idUsuario;
    private int idMonopatin;
    private int idParada;
    private Date fechaInicio;
    private Date fechaFin;
    private float kmRecorridos;
    private float costo;

}
