package webApp.controller;

import webApp.dto.CarreraDTO;
import webApp.entity.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webApp.service.CarreraService;
import java.util.List;

@RestController
@RequestMapping("/Carrera")
public class CarreraController{

@Autowired
private CarreraService carreraService;

@PostMapping("/add")
public ResponseEntity<Carrera> addCarrera(@RequestBody Carrera carrera) {
    Carrera carr = carreraService.addCarrera(carrera);
    return ResponseEntity.ok(carr);
}

@GetMapping("/{id}")
public ResponseEntity<Carrera> getCarrera(@PathVariable Long id) {
    Carrera carr = carreraService.getCarrera(id);
    return ResponseEntity.ok(carr);
}

@GetMapping
public ResponseEntity<List<CarreraDTO>> getCarreras() {
    List<CarreraDTO> carreras = carreraService.getCarreras();
    return ResponseEntity.ok(carreras);
}

@PutMapping("/update/{id}")
public ResponseEntity<String> updateCarrera(@RequestBody String nombre, @PathVariable Long idCarrera) {
    carreraService.updateCarrera(nombre, idCarrera);
    return ResponseEntity.ok("Carrera actualizada con éxito");
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteCarrera(@PathVariable Long id) {
    carreraService.deleteCarrera(id);
    return ResponseEntity.ok("Carrera eliminada con éxito");
}
}