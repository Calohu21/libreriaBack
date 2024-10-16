package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service//
public class LibroService {

    // Este campo privado almacena una referencia al repositorio de libros. El repositorio maneja las interacciones con la base
    // de datos, y el servicio utiliza este repositorio para llevar a cabo las operaciones CRU
    private final LibroRepository libroRepository;

    // Constructor para inyección de dependencias
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Este método llama a findAll() en el repositorio para obtener todos los libros desde la base de datos y devolverlos en una lista
    // Este es un método proporcionado por JpaRepository, que devuelve una lista de todos los registros en la tabla de libros
    // Obtener todos los libros
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }


    // Obtener un libro por su ISBN
    //Llama a findById() del repositorio para buscar el libro por su ISBN. Si no se encuentra el libro, devuelve null utilizando orElse(null)
    public Libro getLibroByIsbn(String isbn) {
        return libroRepository.findById(isbn).orElse(null);
    }

    // Agregar un nuevo libro
    // Llama al método save() del repositorio, que guarda el libro en la base de datos. Si el libro ya existe,
    // será actualizado, pero en este caso se usa para crear un nuevo libro
    public Libro addLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Actualizar un libro existente
    public Libro updateLibro(String isbn, Libro libro) {
        if (libroRepository.existsById(isbn)) { //  Verifica si un libro con el ISBN proporcionado existe en la base de datos. Si existe, continúa con la actualización
            libro.setIsbn(isbn);  // Asegura que el ISBN del libro a actualizar sea el mismo que el proporcionado en la solicitud
            return libroRepository.save(libro);// Llama a save() para actualizar el libro en la base de datos
        }
        return null;
    }

    // Eliminar un libro por su ISBN
    public void deleteLibro(String isbn) {
        libroRepository.deleteById(isbn);
    }
}
