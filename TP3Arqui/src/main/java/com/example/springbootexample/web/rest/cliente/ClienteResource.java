package com.example.springbootexample.web.rest.cliente;

import com.example.springbootexample.service.EstudianteService;
import com.example.springbootexample.service.dto.estudiante.request.EstudianteRequestDTO;
import com.example.springbootexample.service.dto.estudiante.response.EstudianteResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clientes")
@RequiredArgsConstructor
public class ClienteResource {

    private final EstudianteService estudianteService;

    public List<EstudianteResponseDTO> findAll(){
        return this.estudianteService.findAll();
    }

    public EstudianteResponseDTO findById(@PathVariable int dni ){
        return this.estudianteService.findByDNI( dni );
    }

    public List<EstudianteResponseDTO> findById(EstudianteRequestDTO request ){
        return this.estudianteService.search( request );
    }

    @PostMapping("")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody @Valid EstudianteRequestDTO request ){
        final var result = this.estudianteService.save( request );
        return ResponseEntity.accepted().body( result );
    }
}
