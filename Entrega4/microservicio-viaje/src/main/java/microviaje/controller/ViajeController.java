package microviaje.controller;


import microviaje.dto.ViajeDTO;
import microviaje.entity.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import microviaje.service.ViajeService;

import java.util.List;

@RestController
@RequestMapping("api/viajes/viajes")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    // Crear o actualizar un viaje
    @PostMapping
    public ResponseEntity<Viaje> saveViaje(@RequestBody Viaje viaje) {
        Viaje savedViaje = viajeService.saveViaje(viaje);
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
        ViajeDTO viajeDTO = viajeService.getViajeById(id);
        if (viajeDTO != null) {
            return ResponseEntity.ok(viajeDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un viaje por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaje(@PathVariable Long id) {
        if (viajeService.getViajeById(id)!=null) {
            viajeService.deleteViaje(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
