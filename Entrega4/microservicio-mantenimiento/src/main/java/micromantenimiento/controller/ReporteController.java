package micromantenimiento.controller;


import micromantenimiento.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mantenimientos/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;
}
