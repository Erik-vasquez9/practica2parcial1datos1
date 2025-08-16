package com.umg.gestionacademica.presentation.controller;

import com.umg.gestionacademica.data.entity.Profesor;
import com.umg.gestionacademica.service.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    // POST /api/profesores (Crear)
    @PostMapping
    public ResponseEntity<Profesor> crear(@Valid @RequestBody Profesor p) {
        return ResponseEntity.ok(service.crear(p));
    }

    // GET /api/profesores (Obtener todos)
    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // GET /api/profesores/{id} (Obtener por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    // PUT /api/profesores/{id} (Actualizar)
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Long id,
                                               @Valid @RequestBody Profesor p) {
        return ResponseEntity.ok(service.actualizar(id, p));
    }

    // DELETE /api/profesores/{id} (Eliminar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
