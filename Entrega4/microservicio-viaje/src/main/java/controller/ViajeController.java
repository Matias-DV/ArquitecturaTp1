package controller;


import dto.ViajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ViajeService;

import java.util.List;

@RestController
@RequestMapping("api/viajes")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    // Crear o actualizar un viaje
    @PostMapping
    public ResponseEntity<ViajeDTO> saveViaje(@RequestBody ViajeDTO viaje) {
        ViajeDTO savedViaje = viajeService.saveViaje(viaje);
        return ResponseEntity.ok(savedViaje);
    }

    // Obtener todos los viajes
    @GetMapping
    public ResponseEntity<List<ViajeDTO>> getAllViajes() {
        List<ViajeDTO> viajes = viajeService.getAllViajes();
        return ResponseEntity.ok(viajes);
    }

    // Obtener un viaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<ViajeDTO> getViajeById(@PathVariable Long id) {
        return viajeService.getViajeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un viaje por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaje(@PathVariable Long id) {
        if (viajeService.getViajeById(id).isPresent()) {
            viajeService.deleteViaje(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
