package com.example.springbootexample.service;

import com.example.springbootexample.domain.Estudiante;
import com.example.springbootexample.repository.EstudianteRepository;
import com.example.springbootexample.service.dto.estudiante.request.EstudianteRequestDTO;
import com.example.springbootexample.service.dto.estudiante.response.EstudianteResponseDTO;
import com.example.springbootexample.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Transactional
    public EstudianteResponseDTO save(EstudianteRequestDTO request ){
        final var estudiante = new Estudiante( request );
        final var result = this.estudianteRepository.save( estudiante );
        return new EstudianteResponseDTO( result.getDni(), result.getNombre(), result.getApellido(), result.getEdad(), result.getGenero(), result.getCiudad(), result.getLegajo());
    }



}
