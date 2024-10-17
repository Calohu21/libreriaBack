package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Prestamo;
import com.biblioteca.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    // Encuentra todos los préstamos de un usuario//
    List<Prestamo> findByUsuarioId_prestamo(int id_usuario);

    // Encuentra préstamos activos de un usuario (PRESTADO o PENDIENTE)
    List<Prestamo> findByUsuarioId_estado(int id, Prestamo.EstadoPrestamo estado);
}
