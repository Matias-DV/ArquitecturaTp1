package controller;

import entity.Carrera;
import entity.Estudiante;
import org.springframework.http.ResponseEntity;
import service.CarreraService;

public class CarreraController {
    private CarreraService carreraService;

    public ResponseEntity<Carrera> addCarrera(Carrera carrera) {
        Carrera carr = carreraService.addCarrera(carrera);
        return ResponseEntity.ok(carr);
    }
}
