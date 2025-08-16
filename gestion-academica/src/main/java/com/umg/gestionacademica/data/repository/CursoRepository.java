package com.umg.gestionacademica.data.repository;

import com.umg.gestionacademica.data.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {}
