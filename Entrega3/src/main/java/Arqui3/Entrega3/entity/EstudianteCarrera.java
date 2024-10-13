package Arqui3.Entrega3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"dni","ID_Carrera"}))
public class EstudianteCarrera {
    @EmbeddedId
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private EstudianteCarreraId id;

    @JsonIgnore
    @ManyToOne
    @MapsId("dni")
    @JoinColumn(name="dni")
    private Estudiante estudiante;

    @JsonIgnore
    @ManyToOne
    @MapsId("idCarrera")
    @JoinColumn(name="ID_Carrera")
    private Carrera Carrera;
    @Column
    private int antiguedad;
    @Column(nullable = false)
    private boolean esGraduado;
    @Column
    private int fechaInscripcion;
    @Column
    private int fechaEgreso;

    public EstudianteCarrera(int antiguedad, boolean esGraduado, int fechaInscripcion, int fechaEgreso) {
        this.antiguedad = antiguedad;
        this.esGraduado = esGraduado;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaEgreso = fechaEgreso;
    }

    public EstudianteCarrera() {

    }
    public int getFechaEgreso() {
        return fechaEgreso;
    }

    public int getFechaInscripcion() {
        return fechaInscripcion;
    }
    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Boolean getEsGraduado() {
        return esGraduado;
    }

    public void setEsGraduado(boolean esGraduado) {
        this.esGraduado = esGraduado;
    }

    public void setCarrera(Arqui3.Entrega3.entity.Carrera carrera) {
        Carrera = carrera;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "EstudianteCarrera{" +
                "estudiante=" + estudiante +
                ", idCarrera=" + Carrera +
                ", antiguedad=" + antiguedad +
                ", esGraduado=" + esGraduado +
                ", fechaInscripcion=" + fechaInscripcion +
                ", fechaEgreso=" + fechaEgreso +
                '}';
    }
}
