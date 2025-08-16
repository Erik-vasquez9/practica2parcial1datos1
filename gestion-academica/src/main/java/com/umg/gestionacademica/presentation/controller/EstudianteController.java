package com.umg.gestionacademica.presentation.controller;

import com.umg.gestionacademica.data.entity.Estudiante;
import com.umg.gestionacademica.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    // POST /api/estudiantes (Crear)
    @PostMapping
    public ResponseEntity<Estudiante> crear(@Valid @RequestBody Estudiante e) {
        return ResponseEntity.ok(service.crear(e));
    }

    // GET /api/estudiantes (Obtener todos)
    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // GET /api/estudiantes/{id} (Obtener por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    // PUT /api/estudiantes/{id} (Actualizar)
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Long id,
                                                 @Valid @RequestBody Estudiante e) {
        return ResponseEntity.ok(service.actualizar(id, e));
    }

    // DELETE /api/estudiantes/{id} (Eliminar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
