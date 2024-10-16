package com.biblioteca.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="Prestamos")
@Data
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prestamo;

    @ManyToOne
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")  // La columna isbn será generada en la tabla de préstamos automáticamente debido a la relación @ManyToOne entre Prestamo y Libro
    private Libro libro; // Relación con la entidad Libro

    @Column(nullable = false)
    private String usuarioId; // Id del usuario (relacionado con la entidad de usuarios)

    @Column(nullable=false)
    private LocalDate fechaPrestamo;

    @Column(nullable=false)
    private LocalDate fechaDevolucion;


    public enum estado{
        prestado,
        devuelto,
        pendiente
    };

}
