package controller;


import dto.ViajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ViajeService;

import java.util.List;

@RestController
@RequestMapping("api/viajes")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @GetMapping
    public ResponseEntity<List<ViajeDTO>> getViajes() {
        List<ViajeDTO> viajes = viajeService.getViajes();
        return ResponseEntity.ok(viajes);
    }


}
