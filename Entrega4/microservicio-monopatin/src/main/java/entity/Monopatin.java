package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monopatin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_monopatin;
    @Column
    private String ubicacionActual;
    @Column
    private Boolean estaActivo;
    @Column
    private Boolean habilitado;
    @Column
    private Double kilometrosTotales;
    @Column
    private Integer tiempo_uso_total;

    public Monopatin() {
    }

    public Monopatin(int id_monopatin, String ubicacionActual, Boolean estaActivado, Boolean habilitado, Double kilometrosTotales, int tiempo_uso_total) {
        this.id_monopatin = id_monopatin;
        this.ubicacionActual = ubicacionActual;
        this.estaActivado = estaActivado;
        this.habilitado = habilitado;
        this.kilometrosTotales = kilometrosTotales;
        this.tiempo_uso_total = tiempo_uso_total;
    }

    @Override
    public String toString() {
        return "Monopatin{" +
                "id_monopatin=" + id_monopatin +
                ", ubicacionActual='" + ubicacionActual + '\'' +
                ", estaActivado=" + estaActivado +
                ", habilitado=" + habilitado +
                ", kilometrosRecorridos=" + kilometrosRecorridos +
                ", tiempo_uso_total=" + tiempo_uso_total +
                '}';
    }

    
}
