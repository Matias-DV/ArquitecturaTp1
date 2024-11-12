package micromantenimiento.controller;

import micromantenimiento.dto.AdministradorDTO;
import micromantenimiento.entity.Administrador;
import micromantenimiento.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<Administrador> addAdministrador(@RequestBody Administrador administrador) {
        try {
            administradorService.addAdministrador(administrador);
            return new ResponseEntity<>(administrador, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Administrador> updateAdministrador(@PathVariable int id, @RequestBody Administrador administrador) {
        try {
            if (administradorService.getAdministradorById(id) != null) {
                administradorService.updateAdministrador(administrador);
                return new ResponseEntity<>(administrador, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteAdministrador(@PathVariable int id) {
        try {
            if (administradorService.getAdministradorById(id) != null) {
                administradorService.deleteAdministrador(id);
                return ResponseEntity.ok("Administrador eliminado con éxito");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador no encontrado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el administrador.");
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AdministradorDTO> getAdministradorById(@PathVariable int id) {
        try {
            if (administradorService.getAdministradorById(id) != null) {
                AdministradorDTO a = administradorService.getAdministradorById(id);
                return new ResponseEntity<>(a, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<AdministradorDTO>> getAdministradores() {
        List<AdministradorDTO> administradores = administradorService.getAdministradores();
        return ResponseEntity.ok(administradores);
    }
}
