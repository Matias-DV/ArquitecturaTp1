package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Pausa {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPausa;

    private int idViaje;


    public Pausa() {}

    public Pausa(int idPausa, int idViaje) {
        this.idPausa = idPausa;
        this.idViaje = idViaje;
    }
}
