package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Usuario;
import com.biblioteca.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Obtener usuario por Id
    @GetMapping("/{id_usuario}")
    public Usuario getUsuarioById(@PathVariable int id_usuario) {
        return usuarioService.getUsuarioById(id_usuario);
    }

    // Crear un nuevo usuario
    @PostMapping
    public Usuario addUser(@RequestBody Usuario usuario) {
        return usuarioService.addUsuario(usuario);
    }

    // Actualizar usuario
    @PostMapping("/{id_usuario}")
    public Usuario updateUser(@PathVariable Integer id_usuario, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id_usuario, usuario);
    }

    // Eliminar usuario
    @DeleteMapping("/{id_usuario}")
    public void deleteUser(@PathVariable int id_usuario) {
        usuarioService.deleteUsuario(id_usuario);
    }
}
