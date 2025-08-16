package com.umg.gestionacademica.service;

import com.umg.gestionacademica.data.entity.Curso;
import com.umg.gestionacademica.data.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Curso crear(Curso c) {
        return repository.save(c);
    }

    // READ all
    public List<Curso> obtenerTodos() {
        return repository.findAll();
    }

    // READ by ID
    public Curso obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    // UPDATE
    public Curso actualizar(Long id, Curso c) {
        Curso existente = obtenerPorId(id);
        existente.setCodigo(c.getCodigo());
        existente.setNombre(c.getNombre());
        existente.setCreditos(c.getCreditos());
        existente.setSemestreRecomendado(c.getSemestreRecomendado());
        existente.setCicloRecomendado(c.getCicloRecomendado());
        existente.setPrerequisitoCursoId(c.getPrerequisitoCursoId());
        return repository.save(existente);
    }

    // DELETE
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
