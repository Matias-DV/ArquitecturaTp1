package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Monopatin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private boolean estaActivado;

    @Column
    private String ubicacion;

    @Column
    private int kmRecorridos;

    @Column
    private int tiempoUso;

    @Column
    private boolean habilitado;

    public Monopatin() {
    }

    public Monopatin(int id, boolean estaActivado, String ubicacion, int kmRecorridos, int tiempoUso, boolean habilitado) {
        this.id = id;
        this.estaActivado = estaActivado;
        this.ubicacion = ubicacion;
        this.kmRecorridos = kmRecorridos;
        this.tiempoUso = tiempoUso;
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "Monopatin{" +
                "id=" + id +
                ", estaActivado=" + estaActivado +
                ", ubicacion='" + ubicacion + '\'' +
                ", kmRecorridos=" + kmRecorridos +
                ", tiempoUso=" + tiempoUso +
                ", habilitado=" + habilitado +
                '}';
    }
}
