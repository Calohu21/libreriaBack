package com.biblioteca.biblioteca.repository;


// JpaRepository es una interfaz de Spring Data JPA que proporciona una serie de métodos
// predeterminados para realizar operaciones CRUD:
//findAll(): Devuelve una lista de todas las entidades.
//findById(ID id): Devuelve una entidad por su ID (en este caso, por el ISBN del libro).
//save(S entity): Guarda o actualiza una entidad en la base de datos.
//deleteById(ID id): Elimina una entidad por su ID.
//existsById(ID id): Verifica si una entidad existe por su ID.

import com.biblioteca.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Entidad Libro, Id de tipo String
public interface LibroRepository extends JpaRepository<Libro, String> {
    // No es necesario implementar métodos, JPA se encargará del CRUD

}
