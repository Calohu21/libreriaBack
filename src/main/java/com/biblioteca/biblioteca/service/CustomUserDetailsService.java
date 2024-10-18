package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Usuario;
import com.biblioteca.biblioteca.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aquí estamos cargando el usuario por correo electrónico, puedes cambiar esto según tus necesidades
        Usuario usuario = usuarioRepository.findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + username));

        // Convertir el usuario de la base de datos a un UserDetails
        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getPassword())  // Esto debe estar encriptado (BCrypt)
                .roles("USER")  // Por ahora, asignamos el rol de "USER", pero puedes personalizarlo
                .build();
    }
}
