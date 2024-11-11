package micromantenimiento.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Entity
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Getter
    private int idMonopatin;
    @Getter
    @NonNull
    private Date fechaInicio;
    @Getter
    private Date fechaFin;
    public Mantenimiento() {}
    public Mantenimiento(int idMonopatin, Date fechaInicio, Date fechaFin) {
        this.idMonopatin = idMonopatin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

}
