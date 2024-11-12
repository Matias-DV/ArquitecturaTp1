package micromantenimiento.dto;

import lombok.Getter;

@Getter
public class AdministradorDTO {
    private int id;
    private double precioTarifa;
    private double precioTarifaExtra;

    public AdministradorDTO(int id, double precioTarifa, double precioTarifaExtra) {
        this.id = id;
        this.precioTarifa = precioTarifa;
        this.precioTarifaExtra = precioTarifaExtra;
    }
}