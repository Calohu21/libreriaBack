package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    // Se pueden definir consultas personalizadas usando la anotación @Query en el repositorio. En lugar de que Spring genere la
    // consulta automáticamente, tú defines explícitamente cómo debería funcionar la consulta.

    // Encuentra todos los préstamos de un usuario con JPQL
    @Query("SELECT prestamo FROM Prestamo prestamo WHERE prestamo.usuario.id_usuario = :id_usuario")
    List<Prestamo> findByUsuarioId(@Param("id_usuario")int id_usuario);

    // Encuentra préstamos activos de un usuario por su estado con JPQL
    @Query("SELECT prestamo FROM Prestamo prestamo WHERE prestamo.usuario.id_usuario = :id_usuario AND prestamo.estado = :estado")
    List<Prestamo> findByUsuarioIdAndEstado(@Param("id_usuario") int id_usuario, @Param("estado") Prestamo.EstadoPrestamo estado);
}
