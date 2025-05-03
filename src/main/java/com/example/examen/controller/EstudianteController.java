package com.example.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.examen.entity.Estudiante;
import com.example.examen.services.EstudianteService;



@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {


    @Autowired
    private EstudianteService estudianteService;

   
    @PostMapping
    public  ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.guardarEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.listarEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> buscarEstudiantePorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.buscarEstudiantePorId(id);
        if (estudiante != null) {
            return ResponseEntity.ok(estudiante);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteActualizado) {
    Estudiante estudianteExistente = estudianteService.buscarEstudiantePorId(id);
    if (estudianteExistente == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    estudianteExistente.setNombre(estudianteActualizado.getNombre());
    estudianteExistente.setEmail(estudianteActualizado.getEmail());
    estudianteExistente.setNumeroMatricula(estudianteActualizado.getNumeroMatricula());

    Estudiante estudianteGuardado = estudianteService.guardarEstudiante(estudianteExistente);
    return ResponseEntity.ok(estudianteGuardado);
}



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.buscarEstudiantePorId(id);
        if (estudiante == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        estudianteService.eliminarEstudiante(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}
}
    

