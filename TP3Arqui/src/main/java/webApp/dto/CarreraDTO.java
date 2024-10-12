package webApp.dto;

import lombok.Getter;

@Getter
public class CarreraDTO {
    // Getters y setters
    private String nombreCarrera;
        private Long cantidadInscriptos;

        public CarreraDTO(String nombreCarrera, Long cantidadInscriptos) {
            this.nombreCarrera = nombreCarrera;
            this.cantidadInscriptos = cantidadInscriptos;
        }

        public CarreraDTO(String nombreCarrera){
            this.nombreCarrera = nombreCarrera;
        }

    public void setNombreCarrera(String nombreCarrera) {
            this.nombreCarrera = nombreCarrera;
        }

    public void setCantidadInscriptos(Long cantidadInscriptos) {
            this.cantidadInscriptos = cantidadInscriptos;
        }

        @Override
        public String toString() {
            return "CarreraInscriptosDTO{" +
                    "nombreCarrera='" + nombreCarrera + '\'' +
                    ", cantidadInscriptos=" + cantidadInscriptos +
                    '}';
        }
    }