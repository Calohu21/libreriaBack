package com.biblioteca.biblioteca.model;

///
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String gustos_generos;

    @Column
    private int prestamos_activos;

    @Column
    private int prestamos_devueltos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;  // Agrega el campo de rol

    public enum Rol {
        USER,
        ADMIN
    }
}
