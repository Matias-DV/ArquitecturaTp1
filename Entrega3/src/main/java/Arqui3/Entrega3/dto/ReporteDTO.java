package Arqui3.Entrega3.dto;

import lombok.Getter;

public class ReporteDTO {
    private String nombreCarrera;
    private Long cantidadInscriptos;
    private int dniEstudiante;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private int fechaInscripcion;
    private int fechaEgreso;

    // Constructor
    public ReporteDTO(String nombreCarrera, Long cantidadInscriptos,
                               int dniEstudiante, String nombreEstudiante, String apellidoEstudiante, int fechaInscripcion, int fechaEgreso) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadInscriptos = cantidadInscriptos;
        this.dniEstudiante = dniEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaEgreso = fechaEgreso;
    }

    public int getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(int fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(int fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Long getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(Long cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    public int getDniEstudiante() {
        return dniEstudiante;
    }

    public void setDniEstudiante(int dniEstudiante) {
        this.dniEstudiante = dniEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }


}
