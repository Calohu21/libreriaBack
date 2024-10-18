package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Usuario;
import com.biblioteca.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Constructor para inyectar la dependencia
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Crear nuevo usuario
    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Editar usuarios por Id
    public Usuario updateUsuario(int id_usuario, Usuario usuario) {
        if (usuarioRepository.existsById(id_usuario)) {
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    // Eliminar usuario por Id
    public void deleteUsuario(int id_usuario) {
        usuarioRepository.deleteById(id_usuario);
    }
}
