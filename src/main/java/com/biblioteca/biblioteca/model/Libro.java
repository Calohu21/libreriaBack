
// Resumen de cómo interactúan:
//El cliente (frontend o Postman) envía una solicitud HTTP al controlador.
//El controlador recibe la solicitud y la pasa al servicio, que contiene la lógica de negocio.
//El servicio se comunica con el repositorio, que realiza las operaciones sobre la base de datos.
//El repositorio accede a la base de datos y devuelve el resultado al servicio, que a su vez lo pasa al controlador,
//y finalmente, el controlador envía la respuesta al cliente.

package com.biblioteca.biblioteca.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Year;

@Entity // Indica que esta clase es una entidad JPA, es decir, será mapeada a una tabla en la base de datos
@Table(name="Libros") // Especifica que esta entidad corresponde a la tabla libros//
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
