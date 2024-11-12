package micromantenimiento.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDTO {
    private long idReporte;
    private long idMonopatin;
    private int kmRecorridos;
    private int tiempoPausa;
    private int tiempoSinPausa;
}
