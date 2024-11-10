package dto;

public class AdministradorDTO {

    private int precioTarifa;
    private int getPrecioTarifaExtra;

    public AdministradorDTO() {
    }

    public AdministradorDTO(int precioTarifa, int getPrecioTarifaExtra) {
        this.precioTarifa = precioTarifa;
        this.getPrecioTarifaExtra = getPrecioTarifaExtra;
    }

    public int getPrecioTarifa() {
        return precioTarifa;
    }

    public void setPrecioTarifa(int precioTarifa) {
        this.precioTarifa = precioTarifa;
    }

    public int getGetPrecioTarifaExtra() {
        return getPrecioTarifaExtra;
    }

    public void setGetPrecioTarifaExtra(int getPrecioTarifaExtra) {
        this.getPrecioTarifaExtra = getPrecioTarifaExtra;
    }
}
