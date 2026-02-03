package com.salesianostriana.prueba.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> publicEndpoint() {
        return ResponseEntity.ok(Map.of(
                "mensaje", "¡Hola! Este es un endpoint público",
                "descripcion", "Accesible sin autenticación",
                "timestamp", LocalDateTime.now().toString()
        ));
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> publicInfo() {
        return ResponseEntity.ok(Map.of(
                "aplicacion", "Spring Boot JWT Demo",
                "version", "1.0.0",
                "endpoints_publicos", new String[]{"/api/public/**", "/api/auth/**"}
        ));
    }
}
