package com.example.springbootexample.repository;

import com.example.springbootexample.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    public Estudiante findByDNI(int dni);

    Arrays search(String nombre, String email);
}
