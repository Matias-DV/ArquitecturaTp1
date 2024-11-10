package dto;

import lombok.Getter;
import lombok.Setter;

public class PausaDTO {

    @Getter
    @Setter
    private int idPausa;
    @Getter
    @Setter
    private int idViaje;
    @Getter
    @Setter
    private int tiempoTotal;


    public PausaDTO() {
    }

    public PausaDTO(int idPausa, int idViaje, int tiempoTotal) {
        this.idPausa = idPausa;
        this.idViaje = idViaje;
        this.tiempoTotal = tiempoTotal;
    }

    @Override
    public String toString() {
        return "PausaDTO{" +
                "idPausa=" + idPausa +
                ", idViaje=" + idViaje +
                ", tiempoTotal=" + tiempoTotal +
                '}';
    }
}


