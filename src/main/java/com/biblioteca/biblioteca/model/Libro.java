package com.biblioteca.biblioteca.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Year;

@Entity // Indica que esta clase es una entidad JPA, es decir, será mapeada a una tabla en la base de datos
@Table(name="Libros") // Especifica que esta entidad corresponde a la tabla libros/
@Data
public class Libro {

    @Id
    @Column(length= 14)
    private String isbn;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Year anioPublicacion;

    @Column(length = 1000)
    private String descripcion;
}
