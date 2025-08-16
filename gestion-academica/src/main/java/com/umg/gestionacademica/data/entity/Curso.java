package com.umg.gestionacademica.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "Curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private Long cursoId;

    @Column(nullable = false, unique = true, length = 10)
    @NotBlank
    private String codigo;

    @Column(nullable = false, length = 120)
    @NotBlank
    private String nombre;

    @Column(nullable = false)
    @Min(1) @Max(10)
    private Integer creditos;

    // Opcionales
    private Integer semestreRecomendado;
    private Integer cicloRecomendado;

    // FK opcional al propio curso (prerequisito) – lo manejaremos como ID en este CRUD
    private Long prerequisitoCursoId;
}
