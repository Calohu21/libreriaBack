package com.biblioteca.biblioteca.repository;


import com.biblioteca.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    // Método para buscar un usuario por su correo electrónico
    Optional<Usuario> findByCorreo(String correo);
}
