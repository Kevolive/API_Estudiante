package com.example.examen.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
  
    boolean existsByNumeroMatricula(String numeroMatricula);

}
