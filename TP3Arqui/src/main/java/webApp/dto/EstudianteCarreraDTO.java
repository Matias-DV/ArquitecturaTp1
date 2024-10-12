package webApp.dto;

import jakarta.persistence.*;
import webApp.entity.Carrera;
import webApp.entity.Estudiante;

public class EstudianteCarreraDTO {
        private Estudiante estudiante;
        private Carrera carrera;
        private int antiguedad;
        private boolean esGraduado;

        public EstudianteCarreraDTO(Estudiante estudiante, Carrera carrera, int antiguedad, boolean esGraduado) {
            this.estudiante = estudiante;
            this.carrera = carrera;
            this.antiguedad = antiguedad;
            this.esGraduado = esGraduado;
        }

        public EstudianteCarreraDTO() {

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

        public void setCarrera(webApp.entity.Carrera carrera) {
            this.carrera = carrera;
        }

        public void setEstudiante(Estudiante estudiante) {
            this.estudiante = estudiante;
        }

        @Override
        public String toString() {
            return "EstudianteCarrera{" +
                    "estudiante=" + estudiante +
                    ", idCarrera=" + carrera +
                    ", antiguedad=" + antiguedad +
                    ", esGraduado=" + esGraduado +
                    '}';
        }
    }