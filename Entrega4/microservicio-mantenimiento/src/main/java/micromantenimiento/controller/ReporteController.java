package micromantenimiento.controller;


import micromantenimiento.dto.MantenimientoDTO;
import micromantenimiento.models.Monopatin;
import micromantenimiento.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/monopatines/kilometros")
    public ResponseEntity<List<Monopatin>> getReporteMonopatinesPorKilometro() {
        try {
            return new ResponseEntity<>(reporteService.getReporteMonopatinesPorKilometro(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/monopatines/tiempoPausa")
    public ResponseEntity<List<Monopatin>> getReporteMonopatinesPorTiempoPausa() {
        try {
            if (reporteService.getReporteMonopatinesPorTiempoPausa() != null) {
                List<Monopatin> rta = reporteService.getReporteMonopatinesPorTiempoPausa();
                return new ResponseEntity<>(rta, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/monopatines/tiempoSinPausa")
    public ResponseEntity<List<Monopatin>> getReporteMonopatinesPorTiempoSinPausa() {
        try {
            if (reporteService.getReporteMonopatinesPorTiempoSinPausa() != null) {
                List<Monopatin> rta = reporteService.getReporteMonopatinesPorTiempoSinPausa();
                return new ResponseEntity<>(rta, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
