package entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class EstudianteCarrera {
    @Id
    @ManyToOne
    @JoinColumn(name="dni")
    private Estudiante estudiante;
    @Id
    @ManyToOne
    @JoinColumn(name="ID_Carrera")
    private Carrera Carrera;
    @Column
    private int antiguedad;
    @Column(nullable = false)
    private boolean esGraduado;
    @Column
    private Date fechaInscripcion;
    @Column
    private Date fechaEgreso;

    public EstudianteCarrera(int antiguedad, boolean esGraduado, Date fechaInscripcion, Date fechaEgreso) {
        this.antiguedad = antiguedad;
        this.esGraduado = esGraduado;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaEgreso = fechaEgreso;
    }

    public EstudianteCarrera() {

    }
    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public Date getFechaInscripcion() {
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

    public void setCarrera(entity.Carrera carrera) {
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
