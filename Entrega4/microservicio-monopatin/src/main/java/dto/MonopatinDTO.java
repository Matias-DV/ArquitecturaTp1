package dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class MonopatinDTO {

    @Getter
    @Setter
    private boolean estaActivado;

    @Getter
    @Setter
    private String ubicacion;

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private int kmRecorridos;

    @Getter
    @Setter
    private int tiempoUso;

    @Getter
    @Setter
    private boolean habilitado;

    public MonopatinDTO(boolean estaActivado, String ubicacion, int id, int kmRecorridos, int tiempoUso, boolean habilitado) {
        this.estaActivado = estaActivado;
        this.ubicacion = ubicacion;
        this.id = id;
        this.kmRecorridos = kmRecorridos;
        this.tiempoUso = tiempoUso;
        this.habilitado = habilitado;
    }

    public MonopatinDTO() {

    }


    @Override
    public String toString() {
        return "MonopatinDTO{" +
                "estaActivado=" + estaActivado +
                ", ubicacion='" + ubicacion + '\'' +
                ", id=" + id +
                ", kmRecorridos=" + kmRecorridos +
                ", tiempoUso=" + tiempoUso +
                ", habilitado=" + habilitado +
                '}';
    }
}
