package micromantenimiento.controller;

import micromantenimiento.dto.MantenimientoDTO;
import micromantenimiento.entity.Mantenimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import micromantenimiento.service.mantenimientoService;

@RestController
@RequestMapping("api/mantenimiento")
public class mantenimientoController {

    @Autowired
    private mantenimientoService mantenimientoService;

    @PostMapping
    public ResponseEntity<Mantenimiento> addCuenta(@RequestBody Mantenimiento mantenimiento) {
        try{
            mantenimientoService.addMantenimiento(mantenimiento);
            return new ResponseEntity<>(mantenimiento, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Mantenimiento> updateMantenimiento(@PathVariable int id,@RequestBody Mantenimiento mantenimiento) {
        try {
            if (mantenimientoService.getMantenimientoById(id) != null) {
                mantenimientoService.updateMantenimiento(mantenimiento);
                return new ResponseEntity<>(mantenimiento, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteMantenimiento(@PathVariable int idMantenimiento){
        try {
            if (mantenimientoService.getMantenimientoById(idMantenimiento) != null) {
                mantenimientoService.deleteMantenimiento(idMantenimiento);
                return ResponseEntity.ok("Mantenimiento eliminado con éxito");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mantenimiento no encontrado.");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el mantenimiento.");
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MantenimientoDTO> getMantenimientoById(@PathVariable int id){
        try {
            if (mantenimientoService.getMantenimientoById(id) != null) {
                MantenimientoDTO c = mantenimientoService.getMantenimientoById(id);
                return new ResponseEntity<>(c, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}