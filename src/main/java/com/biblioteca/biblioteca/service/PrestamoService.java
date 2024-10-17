package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Prestamo;
import com.biblioteca.biblioteca.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    // Crear un nuevo préstamo
    public Prestamo addPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    // Actualizar préstamo
    public Prestamo updatePrestamo(int id_prestamo, Prestamo prestamo) {
        if (prestamoRepository.existsById(id_prestamo)) {
            prestamo.setId_prestamo(id_prestamo);
            return prestamoRepository.save(prestamo);
        }
        return null;
    }

    // Eliminar préstamo
    public void deletePrestamo(int id_prestamo) {
         prestamoRepository.deleteById(id_prestamo);
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
