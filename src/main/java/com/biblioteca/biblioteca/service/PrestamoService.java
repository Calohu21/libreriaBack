package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.model.Prestamo;
import com.biblioteca.biblioteca.repository.PrestamoRepository;
import org.springframework.stereotype.Service;
import com.biblioteca.biblioteca.repository.PrestamoRepository;

import java.util.List;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    // Obtener todos los préstamos//
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }


    public List<Prestamo> findById_Usuario (int id_usuario) {
        return prestamoRepository.findByUsuarioId_prestamo(id_usuario);
    }

    public List<Prestamo> findByIdUsuario_estado (int id_usuario, String estado) {
        return prestamoRepository.findByUsuarioId_estado(id_usuario, Prestamo.EstadoPrestamo.valueOf(estado));
    }

}
