package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Prestamo;
import com.biblioteca.biblioteca.service.PrestamoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/api/Prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

//    public Prestamo getPrestamo(int id_prestamo) {
//        return prestamoService.findById_Usuario(id_prestamo);
//    }


}
