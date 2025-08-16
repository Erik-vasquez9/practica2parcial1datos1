package com.umg.gestionacademica.presentation.controller;

import com.umg.gestionacademica.data.entity.Curso;
import com.umg.gestionacademica.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    // POST /api/cursos (Crear)
    @PostMapping
    public ResponseEntity<Curso> crear(@Valid @RequestBody Curso c) {
        return ResponseEntity.ok(service.crear(c));
    }

    // GET /api/cursos (Obtener todos)
    @GetMapping
    public ResponseEntity<List<Curso>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // GET /api/cursos/{id} (Obtener por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    // PUT /api/cursos/{id} (Actualizar)
    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Long id,
                                            @Valid @RequestBody Curso c) {
        return ResponseEntity.ok(service.actualizar(id, c));
    }

    // DELETE /api/cursos/{id} (Eliminar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
