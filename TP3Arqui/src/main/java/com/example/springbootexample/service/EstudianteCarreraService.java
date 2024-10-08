package com.example.springbootexample.service;

import com.example.springbootexample.domain.Carrera;
import com.example.springbootexample.domain.Estudiante;
import com.example.springbootexample.domain.EstudianteCarrera;
import com.example.springbootexample.repository.CarreraRepository;
import com.example.springbootexample.repository.EstudianteCarreraRepository;
import com.example.springbootexample.repository.EstudianteRepository;
import com.example.springbootexample.service.dto.carrera.request.CarreraRequestDTO;
import com.example.springbootexample.service.dto.carrera.response.CarreraResponseDTO;
import com.example.springbootexample.service.dto.estudiante.request.EstudianteRequestDTO;
import com.example.springbootexample.service.dto.estudiante.response.EstudianteResponseDTO;
import com.example.springbootexample.service.dto.estudianteCarrera.request.EstudianteCarreraRequestDTO;
import com.example.springbootexample.service.dto.estudianteCarrera.response.EstudianteCarreraResponseDTO;
import com.example.springbootexample.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteCarreraService {

    private final EstudianteCarreraRepository EstudianteCarreraRepository;

    @Transactional
    public EstudianteCarreraResponseDTO save(EstudianteCarreraRequestDTO request ){
        final var estudianteCarrera = new EstudianteCarrera( request );
        final var result = this.EstudianteCarreraRepository.save( estudianteCarrera );
        return new EstudianteCarreraResponseDTO(new EstudianteCarrera(result.getAntiguedad(), result.getEsGraduado(), result.getFechaInscripcion(), result.getFechaEgreso(), result.getCarrera(), result.getEstudiante()));
}

}
