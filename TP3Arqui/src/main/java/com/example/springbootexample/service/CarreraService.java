package com.example.springbootexample.service;

import com.example.springbootexample.domain.Carrera;
import com.example.springbootexample.domain.Estudiante;
import com.example.springbootexample.repository.CarreraRepository;
import com.example.springbootexample.repository.EstudianteRepository;
import com.example.springbootexample.service.dto.carrera.request.CarreraRequestDTO;
import com.example.springbootexample.service.dto.carrera.response.CarreraResponseDTO;
import com.example.springbootexample.service.dto.estudiante.request.EstudianteRequestDTO;
import com.example.springbootexample.service.dto.estudiante.response.EstudianteResponseDTO;
import com.example.springbootexample.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarreraService {

    private final CarreraRepository carreraRepository;

    @Transactional
    public CarreraResponseDTO save(CarreraRequestDTO request ){
        final var carrera = new Carrera( request );
        final var result = this.carreraRepository.save( carrera );
        return new CarreraResponseDTO( result.getId(), result.getNombre());
    }


}
