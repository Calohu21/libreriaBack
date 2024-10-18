package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Prestamo;
import com.biblioteca.biblioteca.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

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

    // Crear un nuevo préstamo
    public Prestamo addPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
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

    // Obtener préstamo por Id
    public List<Prestamo> findById_Usuario (int id_usuario) {
        return prestamoRepository.findByUsuarioId(id_usuario);
    }

    // Obtener todos préstamos por ID usuario y estado
    public List<Prestamo> findByIdUsuario_estado (int id_usuario, String estado) {
        return prestamoRepository.findByUsuarioIdAndEstado(id_usuario, Prestamo.EstadoPrestamo.valueOf(estado));
    }

}
