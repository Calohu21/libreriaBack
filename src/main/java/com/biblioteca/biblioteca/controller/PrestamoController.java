// Este archivo es el controlador que maneja las solicitudes HTTP relacionadas con los préstamos.
// El controlador responde a las solicitudes del cliente (frontend o Postman) y las redirige al servicio correspondiente

package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Prestamo;
import com.biblioteca.biblioteca.service.PrestamoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    // Crear un endpoint para OBTENER todos los préstamos
    @GetMapping
    public List<Prestamo> getAllPrestamos() {
        return prestamoService.getAllPrestamos();
    }

    // Crear un endpoint para CREAR un nuevo libro
    @PostMapping
    public Prestamo addPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.addPrestamo(prestamo);
    }

    // Crean un endpoint para ACTUALIZAR un préstamo
    @PostMapping("/{id_prestamo}")
    public Prestamo updatePrestamo(@RequestBody int id_prestamo, @RequestBody Prestamo prestamo) {
        return prestamoService.updatePrestamo(id_prestamo, prestamo);
    }

    // Crear un endpoint para OBTENER préstamos POR ID
    @GetMapping("/{id_usuario}")
    public List<Prestamo> findByUsuarioId( @PathVariable int id_usuario) {
        return prestamoService.findById_Usuario(id_usuario);
    }

    // Crear un endpoint para OBTENER POR ID los préstamos de un usuario por su ESTADO
    @GetMapping("/usuario/{id_usuario}/estado/{estado}")
    public List<Prestamo> getPrestamosByIdUsuario_estado(@PathVariable int id_usuario, @PathVariable String estado) {
        return prestamoService.findByIdUsuario_estado(id_usuario, estado);
    }

    // Crear un endpoint para ELIMINAR préstamos por id
    @DeleteMapping
    public void deletePrestamoById(int id_prestamo) {
        prestamoService.deletePrestamo(id_prestamo);
    }

}
