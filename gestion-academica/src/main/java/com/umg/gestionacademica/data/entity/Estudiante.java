package com.umg.gestionacademica.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "Estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estudiante_id")
    private Long estudianteId;

    @Column(nullable = false, unique = true, length = 15)
    @NotBlank
    private String carnet;

    @Column(nullable = false, length = 60)
    @NotBlank
    private String nombre;

    @Column(nullable = false, length = 60)
    @NotBlank
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    @NotNull
    private LocalDate fechaNacimiento;
}
