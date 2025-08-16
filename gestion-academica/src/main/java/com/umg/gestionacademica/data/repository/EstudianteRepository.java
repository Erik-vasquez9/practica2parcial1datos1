package com.umg.gestionacademica.data.repository;

import com.umg.gestionacademica.data.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {}
