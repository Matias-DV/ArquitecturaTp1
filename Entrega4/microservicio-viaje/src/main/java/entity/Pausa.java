package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Pausa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPausa;

    @Column
    private long idViaje;

    public Pausa() {}

    public Pausa(long idViaje) {
        this.idPausa = idPausa;
        this.idViaje = idViaje;
    }
}
