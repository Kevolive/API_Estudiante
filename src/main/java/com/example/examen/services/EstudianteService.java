package com.example.examen.services;

import java.util.List;

import com.example.examen.entity.Estudiante;

public interface EstudianteService {
Estudiante guardarEstudiante(Estudiante estudiante);
List<Estudiante> listarEstudiantes();
Estudiante buscarEstudiantePorId(Long id);
void eliminarEstudiante(Long id);
Estudiante actualizarEstudiante(Long id, Estudiante estudiante);

}
