package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/libros")
    public class LibroController {

        private final LibroService libroService;

        public LibroController(LibroService LibroService) {
            this.libroService = LibroService;
        }

        // Obtener todos los libros//
        @GetMapping
        public List<Libro> getAllLibros() {
            return libroService.getAllLibros();
        }

        // Obtener un libro por su ISBN
        //La anotación @PathVariable aplicada a String isbn indica que el valor del ISBN de la URL será asignado a la variable isbn del método.
        //Entonces, si la URL es /api/libros/9783161484100, Spring toma el valor 9783161484100 de la URL y lo pasa al método como el parámetro isbn
        @GetMapping("/{isbn}")
        public Libro getLibroByIsbn(@PathVariable String isbn) {
            return libroService.getLibroByIsbn(isbn);
        }

        // Crear un nuevo libro
        // La solicitud HTTP contendrá los detalles del libro en formato JSON, y @RequestBody se encargará de transformar esos
        // datos JSON en un objeto Libro para que puedas trabajar con él directamente en Java
        @PostMapping
        public Libro addLibro(@RequestBody Libro libro) {
            return libroService.addLibro(libro);
        }

        // Actualizar un libro existente/
        @PutMapping("/{isbn}")
        public Libro updateLibro(@PathVariable String isbn, @RequestBody Libro libro) {
            return libroService.updateLibro(isbn, libro);
        }

        // Eliminar un libro
        @DeleteMapping("/{isbn}")
        public void deleteLibro(@PathVariable String isbn) {
            libroService.deleteLibro(isbn);
        }
    }
