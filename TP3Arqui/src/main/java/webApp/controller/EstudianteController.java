package webApp.controller;

import webApp.dto.EstudianteDTO;
import webApp.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webApp.service.EstudianteService;

import java.util.List;

@RestController
@RequestMapping("/Estudiante")
public class EstudianteController{

@Autowired
private EstudianteService estudianteService;

@PostMapping
public ResponseEntity<Estudiante> addEstudiante(@RequestBody Estudiante estudiante) {
    Estudiante nuevoEstudiante = estudianteService.addEstudiante(estudiante);
    return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
}
    @GetMapping("/legajo/{legajo}")
    public ResponseEntity<EstudianteDTO> getEstudianteByLegajo(@PathVariable int legajo) {
        EstudianteDTO estudiante = estudianteService.getEstudianteByLegajo(legajo);
        if (estudiante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

@GetMapping("/genero/{genero}")
public List<EstudianteDTO> getEstudiantesByGenero(@PathVariable String genero) {
    return estudianteService.getEstudiantesByGenero(genero);
}

@DeleteMapping("/delete/{dni}")
public ResponseEntity<String> deleteEstudiante(@PathVariable int dni) {
    estudianteService.deleteEstudiante(dni);
    return ResponseEntity.ok("Estudiante eliminado con éxito");
}

@PutMapping("/update/{estudiante}")
public ResponseEntity<String> updateEstudiante(@PathVariable int dni) {
    Estudiante e = estudianteService.getEstudianteByDni(dni);
    estudianteService.updateEstudiante(e);
    return ResponseEntity.ok("Estudiante actualizado con éxito");
}


}