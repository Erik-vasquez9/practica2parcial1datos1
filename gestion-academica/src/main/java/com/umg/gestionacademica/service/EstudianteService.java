package com.umg.gestionacademica.service;

import com.umg.gestionacademica.data.entity.Estudiante;
import com.umg.gestionacademica.data.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public Estudiante crear(Estudiante e) {
        return repository.save(e);
    }

    public List<Estudiante> obtenerTodos() {
        return repository.findAll();
    }

    public Estudiante obtenerPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Estudiante actualizar(Long id, Estudiante e) {
        Estudiante existente = repository.findById(id).orElseThrow();
        existente.setCarnet(e.getCarnet());
        existente.setNombre(e.getNombre());
        existente.setApellido(e.getApellido());
        existente.setFechaNacimiento(e.getFechaNacimiento());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
