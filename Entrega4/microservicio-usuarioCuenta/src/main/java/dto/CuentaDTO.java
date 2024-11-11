package dto;

import java.util.Date;

public class CuentaDTO {
    private int id;
    private double saldo;
    private Date fechaAlta;
    private int idMercadoPago;

    public CuentaDTO(int id, double saldo, Date fechaAlta, int idMercadoPago) {
        this.id = id;
        this.saldo = saldo;
        this.fechaAlta = fechaAlta;
        this.idMercadoPago = idMercadoPago;
    }

}
