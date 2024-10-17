package com.biblioteca.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="Prestamos")
@Data
public class Prestamo {
///
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prestamo;

    @ManyToOne
    @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false)  // La columna isbn será generada en la tabla de préstamos automáticamente debido a la relación @ManyToOne entre Prestamo y Libro
    private Libro libro; // Relación con la entidad Libro

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario; // Id del usuario (relacionado con la entidad de usuarios)/

    @Column(nullable=false)
    private LocalDate fechaPrestamo;

    @Column(nullable=false)
    private LocalDate fechaDevolucion;

    public enum EstadoPrestamo{
        PRESTADO,
        DEVUELTO,
        PENDIENTE
    }

    // Utilizar el Enum EstadoPrestamo en lugar de String para la columna estado
    @Enumerated(EnumType.STRING)  // Esto guarda el valor como una cadena en la base de datos
    @Column(nullable = false)
    private EstadoPrestamo estado;

}
