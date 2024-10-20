package com.biblioteca.biblioteca.security;

import com.biblioteca.biblioteca.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  //Deshabilitamos CSRF para simplificar mientras desarrollamos (recuerda habilitarlo en producción)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/usuarios/**").permitAll()  // Rutas públicas para registrar o gestionar usuarios
                        .requestMatchers("/api/prestamos/**").authenticated()  // Rutas que requieren autenticación
                        .anyRequest().authenticated()  // Cualquier otra solicitud requiere autenticación
                )
                .userDetailsService(userDetailsService)  // Asegurarse de usar nuestro servicio
                .httpBasic(withDefaults());  // Configuramos autenticación básica de forma moderna

        return http.build();
    }

    // Bean para codificar las contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean de UserDetailsService para cargar usuarios (lo puedes implementar tú o usar un repositorio)
    @Bean
    public UserDetailsService userDetailsService() {
        // Aquí puedes retornar una implementación de UserDetailsService que cargue los usuarios desde la base de datos
        return username -> {
            // Aquí deberías cargar el usuario de la base de datos (implementación básica)
            throw new RuntimeException("User not found: " + username);
        };
    }
}
