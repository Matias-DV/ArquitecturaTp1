package microviaje.controller;

import microviaje.dto.PausaDTO;
import microviaje.entity.Pausa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import microviaje.service.PausaService;

import java.util.List;

@RestController
@RequestMapping("/api/viajes/pausas")
public class PausaController {

    @Autowired
    private PausaService pausaService;

    @GetMapping()
    public ResponseEntity<List<PausaDTO>> getPausas() {
        return ResponseEntity.ok(pausaService.getPausas());
    }


}
