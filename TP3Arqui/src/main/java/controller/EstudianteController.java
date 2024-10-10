package controller;

import entity.Estudiante;
import org.springframework.http.ResponseEntity;
import service.EstudianteService;

public class EstudianteController {
    private EstudianteService estudianteService;

    public ResponseEntity<Estudiante> addEstudiante(Estudiante estudiante) {
        Estudiante est = estudianteService.addEstudiante(estudiante);
        return ResponseEntity.ok(est);
    }


}
