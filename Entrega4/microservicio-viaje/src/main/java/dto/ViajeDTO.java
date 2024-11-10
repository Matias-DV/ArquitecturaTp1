package dto;

import java.util.Date;

public class ViajeDTO {

    private int idViaje;
    private int idUsuario;
    private int idMonopatin;
    private int idParada;
    private Date fechaInicio;
    private Date fechaFin;
    private float kmRecorridos;
    private float costo;


    public ViajeDTO () {

    }

    public ViajeDTO(int idViaje, int idUsuario, int idMonopatin, int idParada, Date fechaInicio, Date fechaFin, float kmRecorridos, float costo) {
        this.idViaje = idViaje;
        this.idUsuario = idUsuario;
        this.idMonopatin = idMonopatin;
        this.idParada = idParada;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.kmRecorridos = kmRecorridos;
        this.costo = costo;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMonopatin() {
        return idMonopatin;
    }

    public void setIdMonopatin(int idMonopatin) {
        this.idMonopatin = idMonopatin;
    }

    public int getIdParada() {
        return idParada;
    }

    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(float kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "ViajeDTO{" +
                "idViaje=" + idViaje +
                ", idUsuario=" + idUsuario +
                ", idMonopatin=" + idMonopatin +
                ", idParada=" + idParada +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", kmRecorridos=" + kmRecorridos +
                ", costo=" + costo +
                '}';
    }
}
