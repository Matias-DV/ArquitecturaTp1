package com.example.springbootexample.repository;

import com.example.springbootexample.domain.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera,Long> {
}