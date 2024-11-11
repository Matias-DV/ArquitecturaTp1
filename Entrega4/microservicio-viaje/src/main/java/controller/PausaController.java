package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import micromonopatin.service.PausaService;

@RestController
@RequestMapping("/api/pausas")
public class PausaController {

    @Autowired
    private PausaService pausaService;


}
