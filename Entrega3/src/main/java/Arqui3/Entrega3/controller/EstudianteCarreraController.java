package Arqui3.Entrega3.controller;

import Arqui3.Entrega3.dto.CarreraDTO;
import Arqui3.Entrega3.dto.EstudianteCarreraDTO;
import Arqui3.Entrega3.dto.EstudianteDTO;
import Arqui3.Entrega3.entity.Carrera;
import Arqui3.Entrega3.entity.Estudiante;
import Arqui3.Entrega3.entity.EstudianteCarrera;
import Arqui3.Entrega3.service.EstudianteCarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/estudianteCarreras")

public class EstudianteCarreraController {
    @Autowired
    private EstudianteCarreraService estudianteCarreraService;

    @GetMapping
    public ResponseEntity<List<EstudianteCarreraDTO>> getEstudiantesCarreras() {
        List<EstudianteCarreraDTO> carreras = estudianteCarreraService.getEstudiantesCarreras();
        return ResponseEntity.ok(carreras);
    }

    @GetMapping("/ord/inscriptos")
    public ResponseEntity<List<CarreraDTO>> getCarrerasInscriptosOrdenadas() {
        List<CarreraDTO> carreras = estudianteCarreraService.getCarrerasInscriptosOrdenadas();
        return ResponseEntity.ok(carreras);
    }

    @GetMapping("/estudianteByCarreraYCiudad")
    public ResponseEntity<List<EstudianteDTO>> getEstudiantesByCarreraFiltroCiudad(
            @RequestParam("Carrera") long id,
            @RequestParam("Ciudad") String ciudad) {

        List<EstudianteDTO> estudiantes = estudianteCarreraService.getEstudiantesByCarreraFiltroCiudad(id, ciudad);
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping()
    public ResponseEntity<EstudianteCarrera> addEstudianteCarrera(@RequestBody EstudianteCarrera ec) {
        EstudianteCarrera ecAux = estudianteCarreraService.addEstudianteCarrera(ec);
        return ResponseEntity.ok(ecAux);
    }

}
