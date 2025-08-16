package com.umg.gestionacademica.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "Profesor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private Long profesorId;

    @Column(nullable = false, unique = true, length = 10)
    @NotBlank
    private String codigo;

    @Column(name = "nombre_completo", nullable = false, length = 120)
    @NotBlank
    private String nombreCompleto;

    @Column(nullable = false, unique = true, length = 120)
    @Email
    @NotBlank
    private String correo;
}
