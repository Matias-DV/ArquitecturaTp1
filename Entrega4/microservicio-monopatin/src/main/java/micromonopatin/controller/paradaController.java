package micromonopatin.controller;

import micromonopatin.dto.ParadaDTO;
import micromonopatin.entity.Monopatin;
import micromonopatin.entity.Parada;
import micromonopatin.service.paradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paradas")
public class paradaController{
    @Autowired
    private paradaService ps;

    @PostMapping
    public ResponseEntity<Parada> addParada(@RequestBody Parada parada) {
        return ResponseEntity.ok(ps.addParada(parada));
    }

    @GetMapping("/{id_parada}")
    public ResponseEntity<ParadaDTO> getParada(@PathVariable int id_parada) {
        return ResponseEntity.ok(ps.getParada(id_parada));
    }

    @GetMapping
    public ResponseEntity<List<ParadaDTO>> getParadas() {
        return ResponseEntity.ok(ps.getParadas());
    }

    @PutMapping("/id/{id_parada}")
    public ResponseEntity<Parada> updateParada(@PathVariable int id, @RequestBody Parada parada) {
        try {
            if (ps.getParada(id) != null) {
                ps.updateParada(parada);
                return new ResponseEntity<>(parada, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteParada(@PathVariable int idParada){
        try {
            if (ps.getParada(idParada) != null) {
                ps.deleteParada(idParada);
                return ResponseEntity.ok("Parada eliminada con éxito");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parada no encontrada.");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la parada.");
        }
    }

}