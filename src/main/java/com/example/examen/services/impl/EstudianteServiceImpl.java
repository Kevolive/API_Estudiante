// filepath: c:\Users\CESDE\Desktop\examen\src\main\java\com\example\examen\services\impl\EstudianteServiceImpl.java
package com.example.examen.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.entity.Estudiante;
import com.example.examen.repository.EstudianteRepository;
import com.example.examen.services.EstudianteService;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Estudiante buscarEstudiantePorId(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.orElse(null); // Devuelve null si no se encuentra
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {
    Estudiante estudianteExistente = buscarEstudiantePorId(id);
    if (estudianteExistente == null) {
        return null;
    }

    estudianteExistente.setNombre(estudiante.getNombre());
    estudianteExistente.setEmail(estudiante.getEmail());
    estudianteExistente.setNumeroMatricula(estudiante.getNumeroMatricula());

    return estudianteRepository.save(estudianteExistente);
}
}