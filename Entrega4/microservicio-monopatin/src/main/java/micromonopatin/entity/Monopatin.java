package micromonopatin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class  Monopatin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_monopatin;
    @NonNull
    private Boolean estaActivo;
    @NonNull
    private Boolean habilitado;
    @NonNull
    private Double kilometrosTotales;
    private int tiempo_uso_total;
    private int ubicacionX;
    private int ubicacionY;
}
