package micromonopatin.controller;

import micromonopatin.dto.MonopatinDTO;
import micromonopatin.entity.Monopatin;
import micromonopatin.service.monopatinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/monopatines/monopatines")
public class monopatinController{
    @Autowired
    private monopatinService ms;

    @PostMapping
    public ResponseEntity<Monopatin> addMonopatin(@RequestBody Monopatin monopatin) {
        return ResponseEntity.ok(ms.addMonopatin(monopatin));
    }

    @GetMapping
    public ResponseEntity<List<MonopatinDTO>> getMonopatines() {
        return ResponseEntity.ok(ms.getMonopatines());
    }

    @GetMapping("/id/{id_monopatin}")
    public ResponseEntity<MonopatinDTO> getMonopatin(@PathVariable int id_monopatin) {
        return ResponseEntity.ok(ms.getMonopatin(id_monopatin));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Monopatin> updateMantenimiento(@PathVariable int id,@RequestBody Monopatin monopatin) {
        try {
            if (ms.getMonopatinById(id) != null) {
                ms.updateMonopatin(monopatin);
                return new ResponseEntity<>(monopatin, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteMonopatin(@PathVariable int idMonopatin){
        try {
            if (ms.getMonopatin(idMonopatin) != null) {
                ms.deleteMonopatin(idMonopatin);
                return ResponseEntity.ok("Monopatin eliminado con éxito");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Monopatin no encontrado.");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el monopatin.");
        }
    }

}