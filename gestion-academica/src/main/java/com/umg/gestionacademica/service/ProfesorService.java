package com.umg.gestionacademica.service;

import com.umg.gestionacademica.data.entity.Profesor;
import com.umg.gestionacademica.data.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    private final ProfesorRepository repo;

    public ProfesorService(ProfesorRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public Profesor crear(Profesor p) {
        return repo.save(p);
    }

    // READ by ID
    public Profesor obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }

    // READ all
    public List<Profesor> obtenerTodos() {
        return repo.findAll();
    }

    // UPDATE
    public Profesor actualizar(Long id, Profesor p) {
        Profesor db = obtenerPorId(id);
        db.setCodigo(p.getCodigo());
        db.setNombreCompleto(p.getNombreCompleto());
        db.setCorreo(p.getCorreo());
        return repo.save(db);
    }

    // DELETE
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
